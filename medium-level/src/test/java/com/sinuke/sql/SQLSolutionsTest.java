package com.sinuke.sql;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.h2.jdbcx.JdbcDataSource;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class SQLSolutionsTest {

    protected static final List<String> sqlFilesList = new ArrayList<>();
    protected static Connection connection;


    public abstract String getLevelTitle();

    protected abstract Stream<Arguments> testData();

    @BeforeAll
    protected final void basicSetup() throws Exception {
        var ds = new JdbcDataSource();
        ds.setURL("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;MODE=MySQL");
        connection = ds.getConnection();
    }

    @BeforeEach
    void init() throws Exception {
        try (var stmt = connection.createStatement()) {
            // run init scripts (schema.sql, data.sql)
        }
    }

    @AfterAll
    protected void teardown() throws Exception {
        if (connection != null) connection.close();
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    void sqlQueryTest(String sqlPath, Map<String, List<Object>> expected, int size) throws Exception {
        var sql = Files.readString(Path.of(sqlPath));
        try (var statement = connection.createStatement()) {
            var hasResultSet = statement.execute(sql);
            while (hasResultSet) {
                try (var resultSet = statement.getResultSet()) {
                    for (int i = 0; i < size; i++) {
                        assertTrue(resultSet.next());

                        for (var entry : expected.entrySet()) {
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
                    }       
                }
                hasResultSet = statement.getMoreResults();
            }
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class TestResult {

        private String title;
        private String schema = "schema.sql";
        @JsonProperty("input-data")
        private String data = "data.sql";
        @JsonProperty("results-size")
        private int size;
        @JsonProperty("results-map")
        private Map<String, List<Object>> expected;

    }
    
}
