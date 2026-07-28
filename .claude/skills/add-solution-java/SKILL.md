---
name: add-solution-java
description: Creates a Java solution class and test class with test data. Expects difficulty level, problem number, title, and LeetCode link as arguments.
argument-hint: "[level], [number], [title], [link]"
---

For the given difficulty level: $ARGUMENTS[0], problem number: $ARGUMENTS[1], problem title: $ARGUMENTS[2], and LeetCode link: $ARGUMENTS[3], do the following:

1. Create an entry in the README.md file in the folder corresponding to the difficulty level. Place the entry in the correct numeric position. Include problem number, title, link (remove `/description` path), solution file, and test file.

2. Create the solution Java class at `{level}/src/main/java/com/sinuke/{level}/{ClassName}.java`. The class name is PascalCase from the problem title, removing spaces, hyphens, and standalone articles (a, an, the). Use the exact LeetCode method stub signature. Do NOT implement the solution.

3. Create the test class at `{level}/src/test/java/com/sinuke/{level}/{ClassName}Test.java`. Use `@ParameterizedTest` + `@MethodSource("testData")` with `Stream<Arguments>`. Class is package-private (no public modifier). Use `var` for instance creation.

4. Populate test data from LeetCode examples using `Arguments.of(...)`.

5. Add links to created files in README.md. Print full paths as clickable links.

6. Do NOT implement the solution logic. Do NOT run tests after creating templates.
