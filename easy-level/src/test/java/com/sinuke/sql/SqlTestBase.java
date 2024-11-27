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
    void sqlQueryTest(String sqlPath, Map<String, List<String>> expected, int size) throws Exception {
        var sql = Files.readString(Path.of(sqlPath));
        try (var statement = connection.createStatement(); var resultSet = statement.executeQuery(sql)) {
            for (int i = 0; i < size; i++) {
                assertTrue(resultSet.next());

                for (var entry : expected.entrySet()) {
                    assertEquals(entry.getValue().get(i), resultSet.getString(entry.getKey()));
                }
            }
        }
    }
    
    protected abstract Stream<Arguments> testData();
    
}