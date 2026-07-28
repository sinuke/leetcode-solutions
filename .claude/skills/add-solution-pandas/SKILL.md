---
name: add-solution-pandas
description: Creates a Pandas (Python) solution and test files. Expects difficulty level, problem number, title, and LeetCode link as arguments.
argument-hint: "[level], [number], [title], [link]"
---

For the given difficulty level: $ARGUMENTS[0], problem number: $ARGUMENTS[1], problem title: $ARGUMENTS[2], and LeetCode link: $ARGUMENTS[3], do the following:

1. Create an entry in the README.md for the difficulty level at the correct numeric position. Include the problem number, title, link (remove `/description` suffix), and link to the solution `.py` file. If the problem title contains special characters (e.g. `?`), use URL encoding in the link path.

2. Create directory `{level}/pandas/{number}. {Title}/`.

3. Create `{Title}.py` with the function from LeetCode. The `List` type is available without importing (injected by the runner). Input types: `dataframe` (default) or `list_of_lists`. Include `import pandas as pd`.

4. Create `test/test-data.json` with fields: `title`, `number`, `function`, `inputs` (array of objects with `name`, `type`, `file`), `expected` (path string).

5. Create one `test/{input}.json` per input defined in `test-data.json`. Use `"type": "dataframe"` → array of objects, `"type": "list_of_lists"` → array of arrays.

6. Create `test/expected.json` with the expected output matching the function's return type.

7. Print full paths of created files.

8. Do not run tests after creating template files.
