# add-solution-js

Creates a JavaScript solution and test files for a LeetCode JS problem.

## Arguments
- Level: easy, medium, or hard
- Number: LeetCode problem number
- Title: Problem title
- Link: LeetCode problem URL

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
- Do NOT run tests after creation
