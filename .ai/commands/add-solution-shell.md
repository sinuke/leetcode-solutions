# add-solution-shell

Creates a Shell script solution and test files for a LeetCode Shell problem.

## Arguments
- Level: easy, medium, or hard
- Number: LeetCode problem number
- Title: Problem title
- Link: LeetCode problem URL

## Steps

1. **README entry**: Insert at correct numeric position in `{level}/README.md`

2. **Directory**: Create `{level}/shell/{number}. {Title}/`

3. **Solution file**: Create `{number}. {Title}/{Title}.sh` with the shell command(s)

4. **Input file**: Create `{number}. {Title}/test/{input-file}` (e.g., `file.txt` or `input.txt`)

5. **Expected output**: Create `{number}. {Title}/test/expected.txt`

6. **Test config**: Create `{number}. {Title}/test/test-data.json`:
   ```json
   {
     "title": "{Title}",
     "number": {Number},
     "input-data": "{input-file}",
     "working-dir": "/home/user",
     "results-file": "expected.txt"
   }
   ```

7. **Print paths**: Print all created file paths.

## Important
- Do NOT run tests after creation
