package com.sinuke.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
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

    private static final String MYSQL_CONTAINER_WITH_VERSION = "mysql:8.0.26";
    private static final String TEST_DB_NAME = "test_db";
    private static final String TEST_USER = "test_user";
    private static final String TEST_PASSWORD = "test_password";

    private MySQLContainer<?> mysqlContainer;
    private Connection connection;

    protected Map<String, TestData> sqlFilesWithTests;

    @BeforeAll
    protected final void setUp() throws Exception {
        mysqlContainer = new MySQLContainer<>(MYSQL_CONTAINER_WITH_VERSION)
                .withDatabaseName(TEST_DB_NAME)
                .withUsername(TEST_USER)
                .withPassword(TEST_PASSWORD);
        mysqlContainer.start();

        var properties = new Properties();
        properties.setProperty("user", TEST_USER);
        properties.setProperty("password", TEST_PASSWORD);

        connection = mysqlContainer.getJdbcDriverInstance().connect(mysqlContainer.getJdbcUrl(), properties);

        sqlFilesWithTests = scanDirectory(Paths.get("sql/"));
    }

    @AfterAll
    protected final void tearDown() throws Exception {
        if (connection != null) connection.close();
        if (mysqlContainer != null) mysqlContainer.close();
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("testData")
    void sqlSolutionTest(TestData testData, String sqlFile) throws Exception {
        assertNotNull(testData);
        assumeTrue(testData.isEnabled());

        var sqlFilePath = Paths.get(sqlFile);

        var sql = Files.readString(sqlFilePath);
        try (var statement = connection.createStatement()) {
            // given
            var schema = Files.readString(sqlFilePath.getParent().resolve("test/" + testData.getSchema()), StandardCharsets.UTF_8);
            executeSQLContent(statement, schema);
            var data = Files.readString(sqlFilePath.getParent().resolve("test/" + testData.getData()), StandardCharsets.UTF_8);
            executeSQLContent(statement, data);

            // when
            var hasResultSet = statement.execute(sql);

            // then
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

        assertEquals(entry.getValue().get(i), value);
    }

    private Stream<Arguments> testData() {
        return sqlFilesWithTests.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(TestData::getNumber)))
                .map(entry -> Arguments.of(entry.getValue(), entry.getKey()));
    }

    private Map<String, TestData> scanDirectory(Path rootDir) throws IOException {
        Map<String, TestData> result = new HashMap<>();
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
            if (!query.trim().isEmpty()) statement.execute(query);
        }
    }

    @SneakyThrows
    private TestData parseTestDataFromFile(ObjectMapper mapper, File testDataFile) {
        return mapper.readValue(testDataFile, TestData.class);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TestData {

        private boolean enabled = true;
        private String title;
        private int number;
        private String schema = "schema.sql";
        @JsonProperty("input-data")
        private String data = "data.sql";
        @JsonProperty("results-size")
        private int size;
        @JsonProperty("results-map")
        private Map<String, List<Object>> expected;

        @Override
        public String toString() {
            return title;
        }

    }

}
