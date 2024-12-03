package com.sinuke.sql;

import org.junit.jupiter.params.provider.Arguments;

import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class FixNamesInTableTest extends SqlTestBase {

    private final Map<String, List<Object>> expected = Map.of(
            "user_id", List.of(1, 2),
            "name", List.of("Alice", "Bob")
    );

    @Override
    public void setup(Statement statement) throws Exception {
        statement.execute("RUNSCRIPT FROM 'classpath:/FixNamesInTable/schema.sql'");
        statement.execute("RUNSCRIPT FROM 'classpath:/FixNamesInTable/data.sql'");
    }

    @Override
    protected Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("src/main/sql/FixNamesInTable.sql", expected, 2)
        );
    }

}
