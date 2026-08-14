# add-solution-sql

Creates a SQL solution query and test data files for a LeetCode SQL problem.

## Arguments
- Level: easy, medium, or hard
- Number: LeetCode problem number
- Title: Problem title (used as directory name)
- Link: LeetCode problem URL

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
- Fetch LeetCode data with Playwright MCP, not web 
