package com.sinuke.sql;

import org.junit.jupiter.params.provider.Arguments;

import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class CombineTwoTablesTest extends SqlTestBase {

    private final Map<String, List<String>> expected = Map.of(
            "firstName", List.of("Allen", "Bob"),
            "lastName",  List.of("Wang", "Alice"),
            "city",      Arrays.asList(null, "New York City"),
            "state",     Arrays.asList(null, "New York")
    );

    @Override
    public void setup(Statement statement) throws Exception {
        statement.execute("RUNSCRIPT FROM 'classpath:/CombineTwoTables/schema.sql'");
        statement.execute("RUNSCRIPT FROM 'classpath:/CombineTwoTables/data.sql'");
    }

    @Override
    protected Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("sql/CombineTwoTables.sql", expected, 2)
        );
    }

}
