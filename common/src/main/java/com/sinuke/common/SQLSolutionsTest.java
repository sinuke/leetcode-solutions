package com.sinuke.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sinuke.common.model.BaseTestData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@Testcontainers
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class SQLSolutionsTest {

    private static final String MYSQL_CONTAINER_WITH_VERSION = "mysql:9.1.0";
    private static final String TEST_DB_NAME = "test_db";
    private static final String TEST_USER = "test_user";
    private static final String TEST_PASSWORD = "test_password";

    private MySQLContainer<?> mysqlContainer;
    private Connection connection;
    private Map<String, SqlTestData> testDataMap;

    public abstract String getLevelTitle();

    @BeforeAll
    protected final void setUp() throws Exception {
        mysqlContainer = new MySQLContainer<>(MYSQL_CONTAINER_WITH_VERSION)
                .withDatabaseName(TEST_DB_NAME)
                .withUsername(TEST_USER)
                .withPassword(TEST_PASSWORD)
                .withCommand("--log-bin-trust-function-creators=1");
        mysqlContainer.start();

        var properties = new Properties();
        properties.setProperty("user", TEST_USER);
        properties.setProperty("password", TEST_PASSWORD);

        connection = mysqlContainer.getJdbcDriverInstance().connect(mysqlContainer.getJdbcUrl(), properties);

        testDataMap = scanDirectory(Paths.get("sql/"));
    }

    @AfterAll
    protected final void tearDown() throws Exception {
        if (connection != null) connection.close();
        if (mysqlContainer != null) mysqlContainer.close();
    }

    @ParameterizedTest(name = "{0} - {index}: {1}")
    @MethodSource("testData")
    void sqlSolutionTest(String level, SqlTestData sqlTestData, String sqlFile) throws Exception {
        assertNotNull(sqlTestData, "Checks if test data is available");
        assumeTrue(sqlTestData.isEnabled(), "Checks if test is enabled");

        var sqlFilePath = Paths.get(sqlFile);

        try (var statement = connection.createStatement()) {
            // given
            var schema = Files.readString(sqlFilePath.getParent().resolve("test/" + sqlTestData.getSchema()), StandardCharsets.UTF_8);
            executeSQLContent(statement, schema);
            var data = Files.readString(sqlFilePath.getParent().resolve("test/" + sqlTestData.getData()), StandardCharsets.UTF_8);
            executeSQLContent(statement, data);
            var requltsQueryPath = sqlTestData.getResultsQuery() == null ? null : sqlFilePath.getParent().resolve("test/" + sqlTestData.getResultsQuery());
            var solutionContent = Files.readString(sqlFilePath);

            // when
            var hasResultSet = statement.execute(solutionContent);
            if (requltsQueryPath != null) {
                var resultsQueryContent = Files.readString(requltsQueryPath, StandardCharsets.UTF_8);
                hasResultSet = statement.execute(resultsQueryContent);
            }

            // then
            assertTrue(hasResultSet, "Check if solution produced results");

            while (hasResultSet) {
                try (var resultSet = statement.getResultSet()) {
                    for (int i = 0; i < sqlTestData.getSize(); i++) {
                        assertTrue(resultSet.next());

                        for (var entry : sqlTestData.getExpected().entrySet()) {
                            assertValue(resultSet, i, entry);
                        }
                    }
                }
                hasResultSet = statement.getMoreResults();
            }
        }
    }

    private void assertValue(ResultSet resultSet, int i, Map.Entry<String, List<Object>> entry) throws SQLException {
        Object value;

        switch (entry.getValue().get(i)) {
            case Integer ignored -> value = resultSet.getInt(entry.getKey());
            case Long ignored -> value = resultSet.getLong(entry.getKey());
            case Float ignored -> value = resultSet.getFloat(entry.getKey());
            case Double ignored -> value = resultSet.getDouble(entry.getKey());
            case Boolean ignored -> value = resultSet.getBoolean(entry.getKey());
            case Character ignored -> value = resultSet.getString(entry.getKey()).charAt(0);
            case null, default -> value = resultSet.getString(entry.getKey());
        }

        assertEquals(entry.getValue().get(i), value, "Checks if result equals to expected one");
    }

    private Stream<Arguments> testData() {
        return testDataMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(BaseTestData::getNumber)))
                .map(entry -> Arguments.of(getLevelTitle(), entry.getValue(), entry.getKey()));
    }

    private Map<String, SqlTestData> scanDirectory(Path rootDir) throws IOException {
        Map<String, SqlTestData> result = new HashMap<>();
        var mapper = new ObjectMapper();

        try (Stream<Path> walk = Files.walk(rootDir)) {
            walk
                    .filter(Files::isRegularFile)
                    .filter(p -> p.toString().endsWith(".sql"))
                    .filter(p -> !p.getParent().endsWith("test"))
                    .forEach(p -> {
                        var testDataFile = p.getParent().resolve("test/test-data.json");
                        if (Files.exists(testDataFile)) result.put(p.toString(), parseTestDataFromFile(mapper, testDataFile.toFile()));
                        else result.put(p.toString(), null);
                    });
        }

        return result;
    }

    private void executeSQLContent(Statement statement, String content) throws Exception {
        for (var query : content.split(";")) {
            if (!query.trim().isEmpty()) {
                statement.execute(query);
            }
        }
    }

    @SneakyThrows
    private SqlTestData parseTestDataFromFile(ObjectMapper mapper, File testDataFile) {
        return mapper.readValue(testDataFile, SqlTestData.class);
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SqlTestData extends BaseTestData {

        private String schema;
        @JsonProperty("input-data")
        private String data;
        @JsonProperty("results-query")
        private String resultsQuery;
        @JsonProperty("results-size")
        private int size;
        @JsonProperty("results-map")
        private Map<String, List<Object>> expected;

    }
}
