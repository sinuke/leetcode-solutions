# AGENT.md — LeetCode Solutions

This file provides project-wide instructions for any AI coding agent working on this repository.

## Project Overview

Multi-module Gradle project (Java 25) containing LeetCode solutions:

- **`common`** — Shared infrastructure (base test classes, runners, data structures)
- **`easy-level`** — Easy difficulty solutions (Java, SQL, JS, Pandas, Shell)
- **`medium-level`** — Medium difficulty solutions (Java, SQL)
- **`hard-level`** — Hard difficulty solutions (Java, SQL)

LeetCode profile: https://leetcode.com/u/sinuke/

## Available Commands

| Command | Purpose |
|---------|---------|
| `/add-solution-java` | Create a Java solution class, test class, and README entry |
| `/add-solution-sql` | Create a SQL solution query and test data files |
| `/add-solution-js` | Create a JavaScript solution and test files |
| `/add-solution-pandas` | Create a Pandas solution and test files |
| `/add-solution-shell` | Create a Shell script solution and test files |
| `/upgrade-gradle` | Upgrade Gradle dependencies, plugins, and wrapper |

## Java Solutions

### File Locations
- **Solution class**: `{level}/src/main/java/com/sinuke/{level}/{ClassName}.java`
- **Test class**: `{level}/src/test/java/com/sinuke/{level}/{ClassName}Test.java`

Replace `{level}` with `easy`, `medium`, or `hard`, and `{ClassName}` with the PascalCase problem name.

### Class Name Derivation
Remove spaces, hyphens, and standalone articles (a, an, the) from the problem title. Capitalize each word (PascalCase).

Examples:
- "Add Binary" → `AddBinary`
- "Remove Duplicates from Sorted Array" → `RemoveDuplicatesFromSortedArray`
- "To Lower Case" → `ToLowerCase`
- "Find the Index of the First Occurrence in a String" → `FindIndexFirstOccurrenceString`

### Solution Class Template
```java
package com.sinuke.{level};

public class {ClassName} {
    // LeetCode method stub — copy exact signature from LeetCode
    public ... methodName(...) {
        // TODO: implement solution
    }
}
```

Do NOT implement the solution — only create the stub matching the LeetCode method signature. Argument names must match the LeetCode template.

### Test Class Template
```java
package com.sinuke.{level};

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

### Test Conventions
- Class is package-private (no `public` modifier)
- Use `@ParameterizedTest` + `@MethodSource("testData")`
- Use `Stream<Arguments>` for test data
- Use `var` for instance creation: `var solution = new {ClassName}();`
- Import assertions statically: `import static org.junit.jupiter.api.Assertions.*;`

### Example
**AddBinary** (`easy-level/src/main/java/com/sinuke/easy/AddBinary.java`):
```java
public class AddBinary {
    public String addBinary(String a, String b) {
        // stub
    }
}
```

**Test** (`easy-level/src/test/java/com/sinuke/easy/AddBinaryTest.java`):
```java
class AddBinaryTest {
    @ParameterizedTest
    @MethodSource("testData")
    void addBinary(String a, String b, String expected) {
        var addBinary = new AddBinary();
        assertEquals(expected, addBinary.addBinary(a, b));
    }
    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("11", "1", "100"),
                Arguments.of("1010", "1011", "10101"),
                Arguments.of("0", "0", "0")
        );
    }
}
```

## SQL Solutions

### Structure
```
{level}/sql/{number}. {Name}/
├── {Name}.sql              -- Solution query
└── test/
    ├── schema.sql           -- CREATE TABLE statements
    ├── data.sql             -- INSERT test data
    └── test-data.json       -- Test configuration
```

### Rules
- Every `CREATE TABLE` must be preceded by `DROP TABLE IF EXISTS {table_name};`
- Runs against MySQL 9.7.0 via TestContainers
- Test infrastructure in `common/src/main/java/com/sinuke/common/SQLSolutionsTest.java`

### test-data.json Format
```json
{
  "title": "Combine Two Tables",
  "number": 175,
  "schema": "schema.sql",
  "input-data": "data.sql",
  "results-size": 2,
  "results-map": {
    "lastName": ["Wang", "Alice"],
    "state": [null, "New York"],
    "firstName": ["Allen", "Bob"],
    "city": [null, "New York City"]
  }
}
```

### Example
`easy-level/sql/175. Combine Two Tables/Combine Two Tables.sql`:
```sql
SELECT p.firstName, p.lastName, a.city, a.state
FROM Person AS p
LEFT JOIN Address AS a ON a.personId = p.personId;
```

`schema.sql`:
```sql
DROP TABLE IF EXISTS Person;
CREATE TABLE Person (personId INT, lastName VARCHAR(255), firstName VARCHAR(255), PRIMARY KEY (personId));
DROP TABLE IF EXISTS Address;
CREATE TABLE Address (addressId INT, personId INT, city VARCHAR(255), state VARCHAR(255), PRIMARY KEY (addressId));
```

## JavaScript Solutions

### Structure
```
{level}/js/{number}. {Name}/
├── {Name}.js               -- Solution module (CommonJS)
└── test/
    ├── test-data.json       -- Test configuration
    └── expected.json        -- Expected output
```

### Runner Types (in test-data.json `type` field)
| Type | Description |
|------|-------------|
| `simple` | Call `function(...args)` directly |
| `async` | Await async function |
| `prototype` | Create instance, call `instance[method]` |
| `generator` | Call `.next()` N times |
| `calls` | Setup + sequence of method calls |
| `expr` | Evaluate expression directly |
| `timer_test` | Cancellable timer tests |

### test-data.json Format
```json
{
  "title": "Counter",
  "number": 2620,
  "type": "calls",
  "setup": "createCounter",
  "cases": [
    {"setupArgs": [10], "calls": [{"args": []}, {"args": []}, {"args": []}]}
  ],
  "expected": "expected.json"
}
```
`expected.json`: `[[10, 11, 12]]`

Runs via `common/src/main/resources/runner.js` in `node:lts-alpine` container.

## Pandas Solutions

### Structure
```
{level}/pandas/{number}. {Name}/
├── {Name}.py               -- Solution function
└── test/
    ├── test-data.json       -- Test configuration
    ├── {input}.json         -- Input data
    └── expected.json        -- Expected output
```

### Python Conventions
- `List` type is available without importing (injected by runner)
- Input `type` in test-data.json: `"dataframe"` (default) or `"list_of_lists"`

### test-data.json Format
```json
{
  "title": "Create a DataFrame from List",
  "number": 2877,
  "function": "createDataframe",
  "inputs": [
    {"name": "student_data", "type": "list_of_lists", "file": "student_data.json"}
  ],
  "expected": "expected.json"
}
```

### Example
`Create a DataFrame from List.py`:
```python
import pandas as pd

def createDataframe(student_data: List[List[int]]) -> pd.DataFrame:
    return pd.DataFrame(student_data, columns=['student_id', 'age'])
```

Runs via `common/src/main/resources/runner.py` in `python:3.12-slim` container.

## Shell Solutions

### Structure
```
{level}/shell/{number}. {Name}/
├── {Name}.sh               -- Solution script
└── test/
    ├── {input-file}         -- Input file
    ├── expected.txt         -- Expected stdout output
    └── test-data.json       -- Test configuration
```

### test-data.json Format
```json
{
  "title": "Tenth Line",
  "number": 195,
  "input-data": "file.txt",
  "working-dir": "/home/user",
  "results-file": "expected.txt"
}
```

### Example
`Tenth Line.sh`:
```bash
sed -n 10p file.txt
```

Runs in `alpine:latest` container via TestContainers. Test infrastructure in `common/src/main/java/com/sinuke/common/ShellSolutionsTest.java`.

## README Entry

Add each new problem to the correct numeric position in the level's `README.md` table.

### Table Format
```markdown
| # | Problem Name | Description | Solution File | Tests File |
|---|---|---|---|---|
| 1 | Two Sum | https://leetcode.com/problems/two-sum/ | [TwoSum.java](src/main/java/com/sinuke/easy/TwoSum.java) | [TwoSumTest.java](src/test/java/com/sinuke/easy/TwoSumTest.java) |
```

- Remove `/description` suffix from LeetCode URLs
- Links are relative from the level directory
- Add links to both solution file and test files

## Key Infrastructure Files

| File | Purpose |
|------|---------|
| `common/src/main/java/com/sinuke/common/AbstractTestCase.java` | Base parameterized test with `findTestData()` directory walker |
| `common/src/main/java/com/sinuke/common/model/BaseTestData.java` | Base model with `enabled`, `title`, `number` |
| `common/src/main/java/com/sinuke/common/data/ListNode.java` | Linked list node data structure |
| `common/src/main/java/com/sinuke/common/data/TreeNode.java` | Binary tree node data structure |
| `common/src/main/java/com/sinuke/common/data/Node.java` | N-ary tree node data structure |
| `common/src/main/resources/runner.py` | Python runner for Pandas tests |
| `common/src/main/resources/runner.js` | Node.js runner for JS tests |

## Build Commands

```bash
# Build all modules
./gradlew build

# Run all tests
./gradlew test

# Run tests for a single module
./gradlew :easy-level:test
./gradlew :medium-level:test
./gradlew :hard-level:test

# Run a single test class
./gradlew :easy-level:test --tests "com.sinuke.easy.AddBinaryTest"

# Run SQL tests
./gradlew :easy-level:test --tests "com.sinuke.easy.sql.EasyLevelSQLTests"
./gradlew :medium-level:test --tests "com.sinuke.medium.sql.MediumLevelSQLTests"
./gradlew :hard-level:test --tests "com.sinuke.hard.sql.HardLevelSQLTests"

# Run Shell tests
./gradlew :easy-level:test --tests "com.sinuke.easy.shell.EasyLevelShellTests"

# Run Pandas tests
./gradlew :easy-level:test --tests "com.sinuke.easy.pandas.EasyLevelPandasTests"

# Run JS tests
./gradlew :easy-level:test --tests "com.sinuke.easy.js.EasyLevelJsTests"
```

## .gitignore

The following are gitignored and should not be committed:
- `.omo/` — Boulder state files
- `.opencode/` — OpenCode configuration
- `.claude/settings.local.json` — Local Claude settings
- `.playwright-mcp/` — Playwright MCP data
