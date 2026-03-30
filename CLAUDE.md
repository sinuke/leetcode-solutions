# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Commands

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

# Run SQL/Shell/Pandas tests for easy level
./gradlew :easy-level:test --tests "com.sinuke.easy.sql.EasyLevelSQLTests"
./gradlew :easy-level:test --tests "com.sinuke.easy.shell.EasyLevelShellTests"
./gradlew :easy-level:test --tests "com.sinuke.easy.pandas.EasyLevelPandasTests"
```

## Architecture

Multi-module Gradle project (Java 21): `common`, `easy-level`, `medium-level`, `hard-level`. The `common` module provides all shared infrastructure; level modules only declare `implementation project(":common")`.

### Java Solutions

**Solution class** (`easy-level/src/main/java/com/sinuke/easy/`): plain Java class with the exact LeetCode method signature. Class name is PascalCase of the title (articles removed, e.g., `AddBinary`).

**Test class** (`easy-level/src/test/java/com/sinuke/easy/`): package-private class named `<Solution>Test`, uses `@ParameterizedTest` + `@MethodSource("testData")` with inline test cases as `Stream<Arguments>`.

```java
@ParameterizedTest
@MethodSource("testData")
void addBinary(String a, String b, String expected) {
    assertEquals(expected, new AddBinary().addBinary(a, b));
}
private static Stream<Arguments> testData() {
    return Stream.of(Arguments.of("11", "1", "100"));
}
```

Shared data structures in `common/src/main/java/com/sinuke/common/data/`: `ListNode`, `TreeNode`, `Node`.

### SQL / Shell / Pandas Solutions

All three use a three-layer test hierarchy:
```
BaseTestData → AbstractTestCase<T> → SQLSolutionsTest/ShellSolutionsTest/PandasSolutionsTest → EasyLevelSQLTests (one-liner)
```

Each problem lives in its own directory under `easy-level/{type}/{number}. {Name}/`, with the solution file at the root and test data under `test/`.

**SQL** (`easy-level/sql/{number}. {Name}/`):
- `{Name}.sql` — solution query
- `test/schema.sql`, `test/data.sql`, `test/test-data.json`
- `test-data.json`: `title`, `number`, `schema`, `input-data`, `results-size`, `results-map` (column→values), optional `results-query`
- Runs against one `mysql:9.6.0` TestContainers container per class

**Shell** (`easy-level/shell/{number}. {Name}/`):
- `{Name}.sh` — solution script
- `test/{input-file}`, `test/expected.txt`, `test/test-data.json`
- `test-data.json`: `title`, `number`, `input-data`, `working-dir`, `results-file`
- Runs in a fresh `alpine:latest` container per test

**Pandas** (`easy-level/pandas/{number}. {Name}/`):
- `{Name}.py` — solution function (can use `List` without importing — injected by runner)
- `test/test-data.json`, `test/{input}.json`, `test/expected.json`
- `test-data.json`: `title`, `number`, `function`, `inputs` (array with `name`/`type`/`file`), `expected`
- Input `type`: `"dataframe"` (default) or `"list_of_lists"`
- Runs in one `python:3.12-slim` container per class via `common/src/main/resources/runner.py`

### Key Infrastructure Files

- `common/src/main/java/com/sinuke/common/AbstractTestCase.java` — base parameterized test; `findTestData(rootDir, filter, Class<T>)` walks the directory tree
- `common/src/main/java/com/sinuke/common/model/BaseTestData.java` — base model with `enabled`, `title`, `number`
- `common/src/main/resources/runner.py` — Python runner for Pandas tests

### Adding a New Problem

Use the `/add-solution` skill, which handles creating the solution class, test class, and README entry automatically.
