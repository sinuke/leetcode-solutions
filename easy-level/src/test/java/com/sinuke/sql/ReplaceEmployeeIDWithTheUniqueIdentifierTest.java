package com.sinuke.sql;

import org.junit.jupiter.params.provider.Arguments;

import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ReplaceEmployeeIDWithTheUniqueIdentifierTest extends SqlTestBase {

    private final Map<String, List<Object>> expected = Map.of(
            "unique_id", Arrays.asList(null, null, 1, 2, 3),
            "name", List.of("Alice", "Bob", "Jonathan", "Meir", "Winston")
    );

    @Override
    public void setup(Statement statement) throws Exception {
        statement.execute("RUNSCRIPT FROM 'classpath:/ReplaceEmployeeIDWithTheUniqueIdentifier/schema.sql'");
        statement.execute("RUNSCRIPT FROM 'classpath:/ReplaceEmployeeIDWithTheUniqueIdentifier/data.sql'");
    }

    @Override
    protected Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("sql/ReplaceEmployeeIDWithTheUniqueIdentifier.sql", expected, 5)
        );
    }

}
