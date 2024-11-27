package com.sinuke.sql;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DuplicateEmailsTest extends SqlTestBase {

    @Override
    public void setup(Statement statement)  throws Exception {
        statement.execute("RUNSCRIPT FROM 'classpath:/DuplicateEmails/schema.sql'");
        statement.execute("RUNSCRIPT FROM 'classpath:/DuplicateEmails/data.sql'");
    }

    @Test
    void duplicateEmailsTest() throws Exception {
        var sql =  Files.readString(Path.of("src/main/sql/DuplicateEmails.sql"));;
        try (var statement = connection.createStatement(); var resultSet = statement.executeQuery(sql)) {
            assertTrue(resultSet.next());
            assertEquals("a@b.com", resultSet.getString("Email"));
        }
    }
    
}
