---
name: add-solution-js
description: Creates a JavaScript solution and test files. Expects difficulty level, problem number, title, and LeetCode link as arguments.
argument-hint: "[level], [number], [title], [link]"
---

For the given difficulty level: $ARGUMENTS[0], problem number: $ARGUMENTS[1], problem title: $ARGUMENTS[2], and LeetCode link: $ARGUMENTS[3], do the following:

1. Create an entry in the README.md for the difficulty level at the correct numeric position.

2. Create directory `{level}/js/{number}. {Title}/`.

3. Create `{Title}.js` as a CommonJS module with the function/class from LeetCode.

4. Create `test/test-data.json` with fields: title, number, type (one of: simple, async, prototype, generator, calls, expr, timer_test), type-specific fields, and expected pointing to expected.json.

5. Create `test/expected.json` with the expected output.

6. Print full paths of created files.

7. Do not run tests after creating template files.
