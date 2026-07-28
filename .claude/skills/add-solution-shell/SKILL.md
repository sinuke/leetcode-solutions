---
name: add-solution-shell
description: Creates a Shell script solution and test files. Expects difficulty level, problem number, title, and LeetCode link as arguments.
argument-hint: "[level], [number], [title], [link]"
---

For the given difficulty level: $ARGUMENTS[0], problem number: $ARGUMENTS[1], problem title: $ARGUMENTS[2], and LeetCode link: $ARGUMENTS[3], do the following:

1. Create an entry in the README.md for the difficulty level at the correct numeric position.

2. Create directory `{level}/shell/{number}. {Title}/`.

3. Create `{Title}.sh` with the shell command(s).

4. Create `test/{input-file}` with test input data.

5. Create `test/expected.txt` with expected stdout output.

6. Create `test/test-data.json` with fields: title, number, input-data, working-dir, results-file.

7. Print full paths of created files.

8. Do not run tests after creating template files.
