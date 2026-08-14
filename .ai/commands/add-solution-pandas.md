# add-solution-pandas

Creates a Pandas (Python) solution and test files for a LeetCode Pandas problem.

## Arguments
- Level: easy, medium, or hard
- Number: LeetCode problem number
- Title: Problem title
- Link: LeetCode problem URL

## Steps

1. **README entry**: Insert at correct numeric position in `{level}/README.md`

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
- Fetch LeetCode data with Playwright MCP, not web 
