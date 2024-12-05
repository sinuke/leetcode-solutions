package com.sinuke.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.h2.jdbcx.JdbcDataSource;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class SQLSolutionsTest {

    protected static Map<String, TestData> sqlFilesWithTests;
    protected static Connection connection;

    @BeforeAll
    protected final void basicSetup() throws Exception {
        var ds = new JdbcDataSource();
        ds.setURL("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;MODE=MySQL");
        connection = ds.getConnection();

        sqlFilesWithTests = scanDirectory(Paths.get("sql/"));
    }

    @AfterAll
    protected void teardown() throws Exception {
        if (connection != null) connection.close();
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("testData")
    @SneakyThrows
    void sqlSolutionTest(TestData testData, String sqlFile) {
        assertNotNull(testData);
        assumeTrue(testData.isEnabled());

        var sqlFilePath = Paths.get(sqlFile);

        var sql = Files.readString(sqlFilePath);
        try (var statement = connection.createStatement()) {
            // given
            var schemaPath = sqlFilePath.getParent().resolve("test/" + testData.getSchema()).toString();
            statement.execute(String.format("RUNSCRIPT FROM '%s'", schemaPath));
            var dataPath = sqlFilePath.getParent().resolve("test/" + testData.getData()).toString();
            statement.execute(String.format("RUNSCRIPT FROM '%s'", dataPath));

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

    private static void assertValue(ResultSet resultSet, int i, Map.Entry<String, List<Object>> entry) throws SQLException {
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

    private static Stream<Arguments> testData() {
        return sqlFilesWithTests.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(TestData::getNumber)))
                .map(entry -> Arguments.of(entry.getValue(), entry.getKey()));
    }

    @SneakyThrows
    private static Map<String, TestData> scanDirectory(Path rootDir) {
        var objectMapper = new ObjectMapper();
        Map<String, TestData> fileMap = new HashMap<>();

        Files.walkFileTree(rootDir, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                if (!file.getParent().equals(rootDir) && file.toString().endsWith(".sql") && !file.toString().contains("test")) {
                    Path testJsonFile = file.getParent().resolve("test/test-data.json");
                    if (Files.exists(testJsonFile)) {
                        fileMap.put(file.toString(), parseTestDataFromFile(objectMapper, testJsonFile.toFile()));
                    } else fileMap.put(file.toString(), null);
                }
                return FileVisitResult.CONTINUE;
            }
        });

        return fileMap;
    }

    @SneakyThrows
    private static TestData parseTestDataFromFile(ObjectMapper mapper, File testDataFile) {
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
