const fs = require('fs');

const [,, metaPath, solutionPath] = process.argv;

const meta = JSON.parse(fs.readFileSync(metaPath, 'utf8'));
const solutionCode = fs.readFileSync(solutionPath, 'utf8');

// class declarations in eval are block-scoped — convert to var assignments
const processedCode = solutionCode.replace(/\bclass\s+(\w+)\b/g, 'var $1 = class');
eval(processedCode);

function resolveArg(arg) {
    if (arg === null || arg === undefined) return arg;
    if (Array.isArray(arg)) return arg.map(resolveArg);
    if (typeof arg === 'object') {
        if ('$fn' in arg) {
            const code = arg['$fn'].trim();
            // function declarations eval to undefined — wrap in parens to make an expression
            return eval(/^function\s+\w+/.test(code) ? '(' + code + ')' : code);
        }
        if ('$promise' in arg) return Promise.resolve(arg['$promise']);
        return arg;
    }
    return arg;
}

async function runCase(c) {
    const type = meta.type;

    if (type === 'simple') {
        const fn = eval(meta.function);
        const args = (c.args || []).map(resolveArg);
        const result = fn(...args);
        return result === undefined ? null : result;
    }

    if (type === 'async') {
        const fn = eval(meta.function);
        const args = (c.args || []).map(resolveArg);
        const result = await fn(...args);
        return result === undefined ? null : result;
    }

    if (type === 'prototype') {
        const instance = resolveArg(c.instance);
        const args = (c.args || []).map(resolveArg);
        const result = instance[meta.method](...args);
        return result === undefined ? null : result;
    }

    if (type === 'generator') {
        const fn = eval(meta.function);
        const gen = fn();
        const count = c.count || meta.count;
        return Array.from({length: count}, () => gen.next().value);
    }

    if (type === 'calls') {
        const setupFn = eval(meta.setup);
        const setupArgs = (c.setupArgs || []).map(resolveArg);
        const obj = setupFn(...setupArgs);
        const results = [];
        for (const call of (c.calls || [])) {
            const args = (call.args || []).map(resolveArg);
            let ret;
            if (call.method != null) {
                ret = obj[call.method](...args);
            } else {
                ret = typeof obj === 'function' ? obj(...args) : null;
            }
            results.push(ret === undefined ? null : ret);
        }
        return results;
    }

    if (type === 'expr') {
        try {
            const result = eval(c.expr);
            return result === undefined ? null : result;
        } catch (e) {
            return {'$error': String(e)};
        }
    }

    if (type === 'timer_test') {
        console.log = () => {};
        const cancellableFn = eval(meta.function);
        const fnArg = resolveArg(c.fn);
        const callResults = [];
        const trackFn = (...args) => {
            const result = fnArg(...args);
            callResults.push(result === undefined ? null : result);
            return result;
        };
        const cancel = cancellableFn(trackFn, c.args, c.t);
        if (c.cancelAfter === 0) {
            cancel();
        } else if (c.cancelAfter != null) {
            await new Promise(r => setTimeout(r, c.cancelAfter));
            cancel();
        }
        await new Promise(r => setTimeout(r, c.waitMs));
        return callResults;
    }

    throw new Error('Unknown type: ' + type);
}

async function main() {
    const cases = meta.cases || [];
    const results = [];
    for (const c of cases) {
        results.push(await runCase(c));
    }
    process.stdout.write(JSON.stringify(results));
}

main().catch(e => {
    process.stderr.write(String(e));
    process.exit(1);
});
