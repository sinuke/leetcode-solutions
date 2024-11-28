package com.sinuke.sql;

import org.junit.jupiter.params.provider.Arguments;

import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class SwapSalaryTest extends SqlTestBase {

    private final Map<String, List<Object>> expected = Map.of(
            "id", List.of(1, 2, 3, 4),
            "name", List.of("A", "B", "C", "D"),
            "sex", List.of('m', 'f', 'm', 'f'),
            "salary", List.of(2500, 1500, 5500, 500)
    );

    @Override
    public void setup(Statement statement) throws Exception {
        statement.execute("RUNSCRIPT FROM 'classpath:/SwapSalary/schema.sql'");
        statement.execute("RUNSCRIPT FROM 'classpath:/SwapSalary/data.sql'");
    }

    @Override
    protected Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("src/main/sql/SwapSalary.sql", expected, 4)
        );
    }

}
