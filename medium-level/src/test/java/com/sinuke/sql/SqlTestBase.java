package com.sinuke.sql;

import org.h2.jdbcx.JdbcDataSource;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class SqlTestBase {
    
    protected static Connection connection;
    
    @BeforeAll
    protected final void basicSetup() throws Exception {
        var ds = new JdbcDataSource();
        ds.setURL("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
        connection = ds.getConnection();
        try (var stmt = connection.createStatement()) {
            setup(stmt);
        }
    }

    @AfterAll
    protected void teardown() throws Exception {
        if (connection != null) connection.close();
    }
    
    public abstract void setup(Statement statement) throws Exception;
    
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
                            Object value = null;
                            if (entry.getValue().get(i) instanceof String)  value = resultSet.getString(entry.getKey());
                            else if (entry.getValue().get(i) instanceof Integer) value = resultSet.getInt(entry.getKey());
                            else if (entry.getValue().get(i) instanceof Long) value = resultSet.getLong(entry.getKey());
                            else if (entry.getValue().get(i) instanceof Boolean) value = resultSet.getBoolean(entry.getKey());
                            else if (entry.getValue().get(i) instanceof Float) value = resultSet.getFloat(entry.getKey());
                            else if (entry.getValue().get(i) instanceof Character) value = resultSet.getString(entry.getKey()).charAt(0);

                            assertEquals(entry.getValue().get(i), value);
                        }
                    }       
                }
                hasResultSet = statement.getMoreResults();
            }
        }
    }
    
    protected abstract Stream<Arguments> testData();
    
}
