package com.sinuke.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinuke.common.model.BaseTestData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Testcontainers
public abstract class SQLSolutionsTest extends AbstractTestCase<SQLSolutionsTest.SqlTestData> {

    private static final String MYSQL_CONTAINER_WITH_VERSION = "mysql:9.2.0";
    private static final String TEST_DB_NAME = "test_db";
    private static final String TEST_USER = "test_user";
    private static final String TEST_PASSWORD = "test_password";

    private MySQLContainer<?> mysqlContainer;
    private Connection connection;
    private Map<String, SqlTestData> testDataMap;

    @Override
    public void beforeAll() throws Exception {
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

        testDataMap = findTestData(
                "sql/",
                p -> p.toString().endsWith(".sql") && !p.getParent().endsWith("test"),
                SqlTestData.class
        );
    }

    @Override
    public void afterAll() throws Exception {
        if (connection != null) connection.close();
        if (mysqlContainer != null) mysqlContainer.close();
    }

    @Override
    public void beforeEach() {
        // nothing to do
    }

    @Override
    public Map<String, SqlTestData> getTestData() {
        return testDataMap;
    }

    @Override
    public void assertTestCase(SqlTestData testData, String solutionFile) throws Exception {
        var solutionFilePath = Paths.get(solutionFile);

        try (var statement = connection.createStatement()) {
            // given
            var schema = Files.readString(solutionFilePath.getParent().resolve("test/" + testData.getSchema()), StandardCharsets.UTF_8);
            executeSQLContent(statement, schema);
            var data = Files.readString(solutionFilePath.getParent().resolve("test/" + testData.getData()), StandardCharsets.UTF_8);
            executeSQLContent(statement, data);
            var requltsQueryPath = testData.getResultsQuery() == null ? null : solutionFilePath.getParent().resolve("test/" + testData.getResultsQuery());
            var solutionContent = Files.readString(solutionFilePath);

            // when
            var hasResultSet = statement.execute(solutionContent);
            if (requltsQueryPath != null) {
                var resultsQueryContent = Files.readString(requltsQueryPath, StandardCharsets.UTF_8);
                hasResultSet = statement.execute(resultsQueryContent);
            }

            // then
            assertTrue(hasResultSet, "Check that solution produced results");

            while (hasResultSet) {
                try (var resultSet = statement.getResultSet()) {
                    for (int i = 0; i < testData.getSize(); i++) {
                        assertTrue(resultSet.next());

                        for (var entry : testData.getExpected().entrySet()) {
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

        assertEquals(entry.getValue().get(i), value, "Check that result equals to expected one");
    }

    private void executeSQLContent(Statement statement, String content) throws Exception {
        for (var query : content.split(";")) {
            if (!query.trim().isEmpty()) {
                statement.execute(query);
            }
        }
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
