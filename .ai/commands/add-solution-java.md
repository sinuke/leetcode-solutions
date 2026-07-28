# add-solution-java

Creates a Java solution class, test class, and README entry for a LeetCode problem.

## Arguments
- Level: easy, medium, or hard
- Number: LeetCode problem number
- Title: Problem title
- Link: LeetCode problem URL

## Steps

1. **README entry**: Add to the correct numeric position in `{level}/README.md` table:
   - `| # | Problem Name | Description | Solution File | Tests File |`
   - Link: remove `/description` suffix from URL
   - Solution File: `[ClassName.java](src/main/java/com/sinuke/{level}/{ClassName}.java)`
   - Tests File: `[ClassNameTest.java](src/test/java/com/sinuke/{level}/{ClassName}Test.java)`

2. **Solution class**: Create `{level}/src/main/java/com/sinuke/{level}/{ClassName}.java`:
   - Package: `com.sinuke.{level}`
   - Class name: PascalCase, remove articles (a/an/the), spaces, hyphens
   - Method signature: exact copy from LeetCode stub (do NOT implement the solution)

3. **Test class**: Create `{level}/src/test/java/com/sinuke/{level}/{ClassName}Test.java`:
   - Package-private class (no `public` modifier)
   - `@ParameterizedTest` + `@MethodSource("testData")`
   - Use `Stream<Arguments>` return type for testData()
   - Use `var solution = new {ClassName}();`
   - Populate test data from LeetCode examples

4. **Print paths**: Print full paths of all created files.

## Important
- Do NOT implement the solution logic
- Do NOT run tests after creating templates
- Fetch LeetCode data with Playwright if needed, not web search
