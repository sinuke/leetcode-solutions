# add-solution-pandas

Creates a Pandas (Python) solution and test files for a LeetCode Pandas problem.

## Arguments
- Link: LeetCode problem URL

## Fetch problem data
Fetch the problem page at Link using the Playwright CLI (not an MCP browser tool or web search) and extract:
- Title: exact problem title
- Number: LeetCode problem number
- Level: difficulty shown on the page — Easy → `easy`, Medium → `medium`, Hard → `hard`

If the page or its data cannot be retrieved, STOP and report to the user which step failed and why — do not guess Title, Number, or Level.

## Steps

1. **README entry**: Insert at correct numeric position in `{level}/README.md`. If the problem title contains special characters (e.g. `?`), use URL encoding in the link path.

2. **Directory**: Create `{level}/pandas/{number}. {Title}/`

3. **Solution file**: Create `{number}. {Title}/{Title}.py`:
   - Function signature from LeetCode stub
   - `List` type available without import (injected by runner)
   - Return a `pd.DataFrame` where applicable

4. **Test config**: Create `{number}. {Title}/test/test-data.json`:
   ```json
   {
     "title": "{Title}",
     "number": {Number},
     "function": "{functionName}",
     "inputs": [
       {"name": "param1", "type": "dataframe", "file": "param1.json"}
     ],
     "expected": "expected.json"
   }
   ```
   Input types: `"dataframe"` (default) or `"list_of_lists"`

5. **Input data**: Create `{number}. {Title}/test/{input_name}.json` per input defined

6. **Expected output**: Create `{number}. {Title}/test/expected.json`

7. **Print paths**: Print all created file paths.

## Important
- Do NOT implement the solution logic
- Do NOT run tests after creating templates
