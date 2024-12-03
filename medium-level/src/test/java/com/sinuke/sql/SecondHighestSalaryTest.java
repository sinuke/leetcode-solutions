package com.sinuke.sql;

import org.junit.jupiter.params.provider.Arguments;

import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class SecondHighestSalaryTest extends SqlTestBase {

    private final Map<String, List<Integer>> expected = Map.of(
        "SecondHighestSalary", List.of(200)
    );

    @Override
    public void setup(Statement statement) throws Exception {
        statement.execute("RUNSCRIPT FROM 'classpath:/SecondHighestSalary/schema.sql'");
        statement.execute("RUNSCRIPT FROM 'classpath:/SecondHighestSalary/data.sql'");
    }

    @Override
    protected Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("sql/SecondHighestSalary.sql", expected, 1)
        );
    }

}
