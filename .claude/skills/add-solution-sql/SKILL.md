---
name: add-solution-sql
description: Creates a SQL solution query and test data files. Expects difficulty level, problem number, title, and LeetCode link as arguments.
argument-hint: "[level], [number], [title], [link]"
---

For the given difficulty level: $ARGUMENTS[0], problem number: $ARGUMENTS[1], problem title: $ARGUMENTS[2], and LeetCode link: $ARGUMENTS[3], do the following:

1. Create an entry in the README.md for the difficulty level at the correct numeric position.

2. Create directory `{level}/sql/{number}. {Title}/`.

3. Create `{Title}.sql` with the SQL query.

4. Create `test/schema.sql` with CREATE TABLE statements. Each CREATE TABLE must be preceded by DROP TABLE IF EXISTS {table_name}; on its own line. Apply to every table.

5. Create `test/data.sql` with INSERT statements.

6. Create `test/test-data.json` with fields: title, number, schema, input-data, results-size, results-map (column name mapped to array of values).

7. Print full paths of created files.

8. Do not run tests after creating template files.
