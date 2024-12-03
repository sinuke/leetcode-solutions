package com.sinuke.sql;

import org.junit.jupiter.params.provider.Arguments;

import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class SalesPersonTest extends SqlTestBase {

    private final Map<String, List<String>> expected = Map.of(
            "name", List.of("Amy", "Mark", "Alex")
    );

    @Override
    public void setup(Statement statement) throws Exception {
        statement.execute("RUNSCRIPT FROM 'classpath:/SalesPerson/schema.sql'");
        statement.execute("RUNSCRIPT FROM 'classpath:/SalesPerson/data.sql'");
    }

    @Override
    protected Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("sql/SalesPerson.sql", expected, 3)
        );
    }

}
