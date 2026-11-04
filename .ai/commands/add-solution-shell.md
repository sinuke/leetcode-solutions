# add-solution-shell

Creates a Shell script solution and test files for a LeetCode Shell problem.

## Arguments
- Link: LeetCode problem URL

## Fetch problem data
Fetch the problem from LeetCode's GraphQL endpoint with `curl` (not a browser, an MCP browser tool, or web search). Use the variant matching the shell you run commands in — in both, the single quotes keep the JSON body and `$s` intact.

1. Take the problem slug from Link: the path segment right after `/problems/` (e.g. `https://leetcode.com/problems/word-frequency/description/` → `word-frequency`). The slug is only the lookup key — never derive Title or any other data from the URL.
2. Run the command, replacing every `{slug}`.

   bash / Git Bash:
   ```bash
   curl -sS -m 30 https://leetcode.com/graphql \
     -H 'Content-Type: application/json' \
     -H 'Referer: https://leetcode.com/problems/{slug}/' \
     -d '{"query":"query q($s:String!){question(titleSlug:$s){questionFrontendId title difficulty isPaidOnly content codeSnippets{langSlug code}}}","variables":{"s":"{slug}"}}'
   ```

   PowerShell 7.3+ (`pwsh`) — call `curl.exe` explicitly. Windows PowerShell 5.1 is not supported: it strips the quotes inside the JSON argument and LeetCode rejects the request.
   ```powershell
   curl.exe -sS -m 30 https://leetcode.com/graphql -H 'Content-Type: application/json' -H 'Referer: https://leetcode.com/problems/{slug}/' -d '{"query":"query q($s:String!){question(titleSlug:$s){questionFrontendId title difficulty isPaidOnly content codeSnippets{langSlug code}}}","variables":{"s":"{slug}"}}'
   ```
3. Extract from `data.question` in the response:
   - Title: `title` — use exactly as returned
   - Number: `questionFrontendId`
   - Level: `difficulty` — `Easy` → `easy`, `Medium` → `medium`, `Hard` → `hard`
   - Stub: `code` of the `codeSnippets` entry with `langSlug` `bash`
   - Input file name, its sample content, and the expected output: from `content` (HTML)

If curl fails, the response contains `errors`, `data.question` is `null`, or `content` is missing (e.g. a premium-only problem with `isPaidOnly: true`), STOP and report to the user which step failed and why — do not guess Title, Number, or Level.

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
- Do NOT implement the solution logic
- Do NOT run tests after creating templates
