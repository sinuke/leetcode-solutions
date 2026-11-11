# add-solution-java

Creates a Java solution class, test class, and README entry for a LeetCode problem.

## Arguments
- Link: LeetCode problem URL

## Fetch problem data
Fetch the problem from LeetCode's GraphQL endpoint with `curl` (not a browser, an MCP browser tool, or web search). Use the variant matching the shell you run commands in — in both, the single quotes keep the JSON body and `$s` intact.

1. Take the problem slug from Link: the path segment right after `/problems/` (e.g. `https://leetcode.com/problems/word-search/description/` → `word-search`). The slug is only the lookup key — never derive Title or any other data from the URL.
2. Run the command, replacing every `{slug}`.

   bash / Git Bash:
   ```bash
   curl -sS -m 30 https://leetcode.com/graphql \
     -H 'Content-Type: application/json' \
     -H 'Referer: https://leetcode.com/problems/{slug}/' \
     -d '{"query":"query q($s:String!){question(titleSlug:$s){questionFrontendId title difficulty isPaidOnly content exampleTestcaseList codeSnippets{langSlug code}}}","variables":{"s":"{slug}"}}'
   ```

   PowerShell 7.3+ (`pwsh`) — call `curl.exe` explicitly. Windows PowerShell 5.1 is not supported: it strips the quotes inside the JSON argument and LeetCode rejects the request.
   ```powershell
   curl.exe -sS -m 30 https://leetcode.com/graphql -H 'Content-Type: application/json' -H 'Referer: https://leetcode.com/problems/{slug}/' -d '{"query":"query q($s:String!){question(titleSlug:$s){questionFrontendId title difficulty isPaidOnly content exampleTestcaseList codeSnippets{langSlug code}}}","variables":{"s":"{slug}"}}'
   ```
3. Extract from `data.question` in the response:
   - Title: `title` — use exactly as returned
   - Number: `questionFrontendId`
   - Level: `difficulty` — `Easy` → `easy`, `Medium` → `medium`, `Hard` → `hard`
   - Stub: `code` of the `codeSnippets` entry with `langSlug` `java` — the source of the method signature
   - Examples: inputs and outputs from the "Example" sections of `content` (HTML); `exampleTestcaseList` holds the raw example inputs

If curl fails, the response contains `errors`, `data.question` is `null`, or `content` or the `java` snippet is missing (e.g. a premium-only problem with `isPaidOnly: true`), STOP and report to the user which step failed and why — do not guess Title, Number, Level, or the method signature.

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

## Design problems
Apply this section when the title starts with "Design" or the LeetCode Java stub is a class (constructor plus methods) instead of a single method. Examples in the repo: `DesignTwitter`, `DesignCircularQueue`, `DesignBrowserHistory`, `DesignLRUCache`.

- **Naming**: outer class `Design{PascalCaseTitle}` (e.g. "Design Twitter" → `DesignTwitter`, "LRU Cache" → `DesignLRUCache`; do not repeat "Design" if the title already has it). Nested `public static class` uses the exact class name from the LeetCode Java stub (`Twitter`, `MyCircularQueue`, `LRUCache`).
- **Solution file**: `Design{PascalCaseTitle}.java` with the nested class. Constructor and `void` methods get `// TODO: implement solution` and an empty body. Non-void methods get the TODO plus `throw new UnsupportedOperationException();`, so the file compiles.
- **Test file**: `Design{PascalCaseTitle}Test.java` does not use the standard `var solution = new ...` shape. Follow `DesignCircularQueueTest` / `DesignTwitterTest`:
  - Signature `void {camelCaseTitle}Test(String[] operations, Object[] values, Object[] expected)`. Use `Integer[]` instead of `Object[]` for `values` only when every value is a single int.
  - Declare `DesignX.NestedClass solution = null;` and loop over `operations`, switching on the operation name.
  - The constructor operation (named after the nested class) creates the instance, with `actual[i] = null`.
  - Void operations set `actual[i] = null`. Multi-argument operations take an `int[]` in `values[i]`. Single-argument operations take the value directly and cast it.
  - `default` throws `IllegalArgumentException("Unknown operation " + operations[i])`.
  - Expected data: `null` for void operations, otherwise the returned value. Assert with `assertArrayEquals(expected, actual)`.
  - Test data: the first case is the LeetCode example. Add one or two extra cases for edge behavior, such as eviction, updates, or empty state.
  - Method order rules still apply: the `@ParameterizedTest` method first, `testData()` last.
- **README**: link both files as usual, with the `Design{PascalCaseTitle}` names.

## Important
- Do NOT implement the solution logic
- Do NOT run tests after creating templates
- Never invent a method signature — if it can't be retrieved from LeetCode, stop and explain why instead of guessing
- Never reorder the test class methods — test method first, `testData()` last
