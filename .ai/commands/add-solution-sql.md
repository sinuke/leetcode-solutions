# add-solution-sql

Creates a SQL solution query and test data files for a LeetCode SQL problem.

## Arguments
- Link: LeetCode problem URL

## Fetch problem data
Fetch the problem from LeetCode's GraphQL endpoint with `curl` (not a browser, an MCP browser tool, or web search). Use the variant matching the shell you run commands in — in both, the single quotes keep the JSON body and `$s` intact.

1. Take the problem slug from Link: the path segment right after `/problems/` (e.g. `https://leetcode.com/problems/combine-two-tables/description/` → `combine-two-tables`). The slug is only the lookup key — never derive Title or any other data from the URL.
2. Run the command, replacing every `{slug}`.

   bash / Git Bash:
   ```bash
   curl -sS -m 30 https://leetcode.com/graphql \
     -H 'Content-Type: application/json' \
     -H 'Referer: https://leetcode.com/problems/{slug}/' \
     -d '{"query":"query q($s:String!){question(titleSlug:$s){questionFrontendId title difficulty isPaidOnly content mysqlSchemas}}","variables":{"s":"{slug}"}}'
   ```

   PowerShell 7.3+ (`pwsh`) — call `curl.exe` explicitly. Windows PowerShell 5.1 is not supported: it strips the quotes inside the JSON argument and LeetCode rejects the request.
   ```powershell
   curl.exe -sS -m 30 https://leetcode.com/graphql -H 'Content-Type: application/json' -H 'Referer: https://leetcode.com/problems/{slug}/' -d '{"query":"query q($s:String!){question(titleSlug:$s){questionFrontendId title difficulty isPaidOnly content mysqlSchemas}}","variables":{"s":"{slug}"}}'
   ```
3. Extract from `data.question` in the response:
   - Title: `title` — use exactly as returned (used as directory name)
   - Number: `questionFrontendId`
   - Level: `difficulty` — `Easy` → `easy`, `Medium` → `medium`, `Hard` → `hard`
   - Schema and data: `mysqlSchemas` — `Create table ...` statements give the tables, `insert into ...` statements give the rows; ignore `Truncate table ...`
   - Expected result: the Output table of the example in `content` (HTML)

If curl fails, the response contains `errors`, `data.question` is `null`, or `content` or `mysqlSchemas` is missing or empty (e.g. a premium-only problem with `isPaidOnly: true`), STOP and report to the user which step failed and why — do not guess Title, Number, Level, schema, or data.

## Steps

1. **README entry**: Insert at correct numeric position in `{level}/README.md`:
   - Link to `sql/{number}. {Title}/{Title}.sql`

2. **Directory**: Create `{level}/sql/{number}. {Title}/`

3. **Solution file**: Create `{number}. {Title}/{Title}.sql` with the SQL query

4. **Schema file**: Create `{number}. {Title}/test/schema.sql`:
   - Each `CREATE TABLE` preceded by `DROP TABLE IF EXISTS {table_name};`
   - Include all tables from the problem

5. **Data file**: Create `{number}. {Title}/test/data.sql` with INSERT statements

6. **Test config**: Create `{number}. {Title}/test/test-data.json`:
   ```json
   {
     "title": "{Title}",
     "number": {Number},
     "schema": "schema.sql",
     "input-data": "data.sql",
     "results-size": N,
     "results-map": {
       "column1": [values...]
     }
   }
   ```

7. **Print paths**: Print all created file paths.

## Important
- Do NOT implement the solution logic
- Do NOT run tests after creating templates
