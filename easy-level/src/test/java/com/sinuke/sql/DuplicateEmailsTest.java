package com.sinuke.sql;

import org.junit.jupiter.params.provider.Arguments;

import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class DuplicateEmailsTest extends SqlTestBase {
    
    private final Map<String, List<String>> expected = Map.of(
            "Email", List.of("a@b.com")
    );

    @Override
    public void setup(Statement statement)  throws Exception {
        statement.execute("RUNSCRIPT FROM 'classpath:/DuplicateEmails/schema.sql'");
        statement.execute("RUNSCRIPT FROM 'classpath:/DuplicateEmails/data.sql'");
    }

    @Override
    protected Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("sql/DuplicateEmails.sql", expected, 1)
        );
    }

}
