---
name: add-solution
description: Creates a solution class and a test class with test data. Expects difficulty level, problem number, title, and LeetCode link as arguments.
argument-hint: "[level], [number], [title], [link]"
---

For the given difficulty level: $ARGUMENTS[0], problem number: $ARGUMENTS[1], problem title: $ARGUMENTS[2], and LeetCode link: $ARGUMENTS[3], do the following:
1. Create an entry in the README.md file in the folder corresponding to the difficulty level (easy-level, medium-level, or hard-level). Place the entry in the correct position in the list according to the number. The entry must include the problem number, title, and link to the LeetCode page. Remove the path starting from /description from the link.
2. Create the corresponding solution Java class. The class name is derived from the problem title by removing spaces, hyphens, and the standalone articles "a", "an", "the". Each word in the class name must be capitalized (PascalCase). The class body must match the LeetCode stub (without a solution). Follow the pattern used by other existing classes.
3. Create a test class for the problem. Use parameterized tests. Look at how other test classes are structured for reference. Always use @MethodSource("testData").
4. Populate the test class with test data and expected results as shown on LeetCode.
5. Add links to the created files in the README.md file.
6. Do not suggest implementing, solving, or improving the solution.