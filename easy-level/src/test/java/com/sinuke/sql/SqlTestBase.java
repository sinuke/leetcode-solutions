package com.sinuke.sql;

import org.h2.jdbcx.JdbcDataSource;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

import java.sql.Connection;
import java.sql.Statement;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class SqlTestBase {
    
    protected static Connection connection;
    
    @BeforeAll
    protected final void basicSetup() throws Exception {
        var ds = new JdbcDataSource();
        ds.setURL("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
        connection = ds.getConnection();
        try (var stmt = connection.createStatement()) {
//            stmt.execute("RUNSCRIPT FROM 'classpath:/DuplicateEmails/schema.sql'");
//            stmt.execute("RUNSCRIPT FROM 'classpath:/DuplicateEmails/data.sql'");
            setup(stmt);
        }
    }

    @AfterAll
    protected void teardown() throws Exception {
        if (connection != null) connection.close();
    }
    
    public abstract void setup(Statement statement) throws Exception;
    
}
