# add-solution-java

Creates a Java solution class, test class, and README entry for a LeetCode problem.

## Arguments
- Link: LeetCode problem URL

## Fetch problem data
Fetch the problem page at Link using the Playwright CLI (not an MCP browser tool or web search) and extract:
- Title: exact problem title
- Number: LeetCode problem number
- Level: difficulty shown on the page — Easy → `easy`, Medium → `medium`, Hard → `hard`

If the page or its data cannot be retrieved, STOP and report to the user which step failed and why — do not guess Title, Number, or Level.

## Steps

1. **README entry**: Add to the correct numeric position in `{level}/README.md` table:
   - `| # | Problem Name | Description | Solution File | Tests File |`
   - Link: remove `/description` suffix from URL
   - Solution File: `[ClassName.java](src/main/java/com/sinuke/{level}/{ClassName}.java)`
   - Tests File: `[ClassNameTest.java](src/test/java/com/sinuke/{level}/{ClassName}Test.java)`

2. **Solution class**: Create `{level}/src/main/java/com/sinuke/{level}/{ClassName}.java`:
   - Package: `com.sinuke.{level}`
   - Class name: PascalCase, remove articles (a/an/the), spaces, hyphens
   - Method signature: exact copy from the LeetCode stub — same method name, parameter names, parameter order, and return type. Do NOT implement the solution.
   - Never invent your own method signature. If the exact LeetCode signature cannot be retrieved, STOP and report to the user which step failed and why — do not guess or fabricate one.

3. **Test class**: Create `{level}/src/test/java/com/sinuke/{level}/{ClassName}Test.java`:
   - Package-private class (no `public` modifier)
   - Follow this exact structure and method order — the test method always comes first, `testData()` always comes last, never swap them:
     ```java
     class {ClassName}Test {

         @ParameterizedTest
         @MethodSource("testData")
         void {methodName}(/* parameters */) {
             var solution = new {ClassName}();
             assertEquals(expected, solution.{methodName}(/* args */));
         }

         private static Stream<Arguments> testData() {
             return Stream.of(
                     Arguments.of(/* input, expected */)
             );
         }

     }
     ```
   - Use `Stream<Arguments>` return type for testData()
   - Use `var solution = new {ClassName}();`
   - Populate test data from LeetCode examples
   - This is the standard structure for most Java solution tests and should be used whenever applicable. Problems needing custom setup or comparison (e.g. `TreeNode`, `ListNode`, or other non-trivial input/output construction) may deviate — follow the pattern used by similar existing tests in the repo instead.

4. **Print paths**: Print full paths of all created files.

## Important
- Do NOT implement the solution logic
- Do NOT run tests after creating templates
- Never invent a method signature — if it can't be retrieved from LeetCode, stop and explain why instead of guessing
- Never reorder the test class methods — test method first, `testData()` last
