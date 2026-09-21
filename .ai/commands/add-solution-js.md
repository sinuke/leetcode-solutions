# add-solution-js

Creates a JavaScript solution and test files for a LeetCode JS problem.

## Arguments
- Link: LeetCode problem URL

## Fetch problem data
Fetch the problem page at Link using the Playwright CLI (not an MCP browser tool or web search) and extract:
- Title: exact problem title
- Number: LeetCode problem number
- Level: difficulty shown on the page — Easy → `easy`, Medium → `medium`, Hard → `hard`

If the page or its data cannot be retrieved, STOP and report to the user which step failed and why — do not guess Title, Number, or Level.

## Steps

1. **README entry**: Insert at correct numeric position in `{level}/README.md`

2. **Directory**: Create `{level}/js/{number}. {Title}/`

3. **Solution file**: Create `{number}. {Title}/{Title}.js` as a CommonJS module

4. **Test config**: Create `{number}. {Title}/test/test-data.json`:
   ```json
   {
     "title": "{Title}",
     "number": {Number},
     "type": "simple",
     "function": "{functionName}",
     "args": [...],
     "expected": "expected.json"
   }
   ```
   Pick the correct `type` from: simple, async, prototype, generator, calls, expr, timer_test

5. **Expected output**: Create `{number}. {Title}/test/expected.json`

6. **Print paths**: Print all created file paths.

## Important
- Do NOT implement the solution logic
- Do NOT run tests after creating templates
