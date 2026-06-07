---
name: upgrade-gradle
description: Upgrade Gradle dependencies, plugins, and wrapper to latest stable versions. Use this skill whenever the user mentions upgrading, updating, or bumping Gradle dependencies, plugins, Gradle wrapper, or library versions in the build.gradle. Also triggers for "check for updates", "update dependencies", "bump versions", or any variation of wanting newer library versions.
---

# Upgrade Gradle Dependencies

Upgrade all dependencies, plugins, jacoco toolVersion, and the Gradle wrapper to their latest **stable** versions (no alpha, beta, RC, or milestone releases). After updating, if the MySQL version changed, sync the Docker image tag in `SQLSolutionsTest.java`.

## Files to update

- `build.gradle` (root) — all versions live here: `ext` block variables, plugin `version '...'` declarations, `jacoco { toolVersion }`
- `gradle/wrapper/gradle-wrapper.properties` — Gradle wrapper `distributionUrl`
- `common/src/main/java/com/sinuke/common/SQLSolutionsTest.java` — `MYSQL_CONTAINER_WITH_VERSION` constant (only if `version_mysql` changed)

## Step 1: Read current versions

Read `build.gradle` and extract:
- Plugin versions from the `plugins {}` block
- `jacoco { toolVersion }`
- All `version_*` entries in the `ext {}` block

Read `gradle/wrapper/gradle-wrapper.properties` and extract the current Gradle version from `distributionUrl`.

## Step 2: Look up latest stable versions in parallel

Use the Maven Central metadata endpoint — it is more reliable than the search API:

```
https://repo1.maven.org/maven2/{groupId/with/slashes}/{artifactId}/maven-metadata.xml
```

The `<release>` tag gives the latest release. Skip it if it matches a pre-release pattern: `-alpha`, `-beta`, `-RC`, `-M\d`, `-milestone`, `-SNAPSHOT` (case-insensitive). In that case, find the highest version in the `<versions>` list that is stable.

### Dependencies (groupId:artifactId → ext variable → metadata URL)

| ext variable | metadata URL |
|---|---|
| version_jackson | https://repo1.maven.org/maven2/tools/jackson/core/jackson-databind/maven-metadata.xml |
| version_logback | https://repo1.maven.org/maven2/ch/qos/logback/logback-classic/maven-metadata.xml |
| version_junit | https://repo1.maven.org/maven2/org/junit/junit-bom/maven-metadata.xml |
| version_testcontainers | https://repo1.maven.org/maven2/org/testcontainers/testcontainers/maven-metadata.xml |
| version_mysql | https://repo1.maven.org/maven2/com/mysql/mysql-connector-j/maven-metadata.xml |
| jacoco toolVersion | https://repo1.maven.org/maven2/org/jacoco/org.jacoco.core/maven-metadata.xml |

### Plugins (Gradle Plugin Portal)

| Plugin ID | metadata URL |
|---|---|
| com.adarshr.test-logger | https://plugins.gradle.org/m2/com/adarshr/gradle-test-logger-plugin/maven-metadata.xml |
| io.freefair.lombok | https://plugins.gradle.org/m2/io/freefair/gradle/lombok-plugin/maven-metadata.xml |

### Gradle wrapper

```
https://services.gradle.org/versions/current
```
Response JSON has `version` and `downloadUrl` fields. Use `downloadUrl` directly as the new `distributionUrl`.

## Step 3: Show a comparison table

Before making any changes, print a table like this (skip the "ok" rows if you want to keep it short):

```
| Component               | Current  | Latest   | Action  |
|-------------------------|----------|----------|---------|
| jackson-databind        | 3.1.3    | 3.1.4    | UPDATE  |
| logback-classic         | 1.5.32   | 1.5.34   | UPDATE  |
| junit-bom               | 6.0.3    | 6.1.0    | UPDATE  |
| testcontainers          | 2.0.5    | 2.0.5    | ok      |
| mysql-connector-j       | 9.7.0    | 9.7.0    | ok      |
| test-logger plugin      | 4.0.0    | 4.0.0    | ok      |
| lombok plugin           | 9.5.0    | 9.5.0    | ok      |
| jacoco toolVersion      | 0.8.14   | 0.8.15   | UPDATE  |
| Gradle wrapper          | 9.4.1    | 9.5.1    | UPDATE  |
```

If nothing needs updating, say so and stop.

## Step 4: Apply updates

For each component marked UPDATE:

**In `build.gradle`:**
- Plugin versions: update the `version '...'` string in the `plugins {}` block
- `jacoco { toolVersion = "..." }`
- `ext` variables: update the quoted version strings

**In `gradle/wrapper/gradle-wrapper.properties`:**
- Replace `distributionUrl` with the new value from `downloadUrl` (escape colons as `\:`)

## Step 5: Sync MySQL Docker image (conditional)

If `version_mysql` changed, open `common/src/main/java/com/sinuke/common/SQLSolutionsTest.java` and update:

```java
private static final String MYSQL_CONTAINER_WITH_VERSION = "mysql:{new_version}";
```

The version must exactly match the new `version_mysql` value.

## Done

List all files modified. Do not run any build commands — leave testing to the user.
