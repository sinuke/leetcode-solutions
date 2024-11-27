package com.sinuke.sql;

import org.junit.jupiter.params.provider.Arguments;

import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class DeleteDuplicateEmailsTest extends SqlTestBase {
    
    private final Map<String, List<Object>> expected = Map.of(
            "id", List.of(1, 2),
            "email", List.of("john@example.com", "bob@example.com")
    );
    
    @Override
    public void setup(Statement statement) throws Exception {
        statement.execute("RUNSCRIPT FROM 'classpath:/DeleteDuplicateEmails/schema.sql'");
        statement.execute("RUNSCRIPT FROM 'classpath:/DeleteDuplicateEmails/data.sql'");    
    }

    @Override
    protected Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("src/main/sql/DeleteDuplicateEmails.sql", expected, 2)
        );
    }
    
}
