package com.sinuke.sql;

import org.junit.jupiter.params.provider.Arguments;

import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class FindTotalTimeSpentByEachEmployeeTest extends SqlTestBase {

    private final Map<String, List<Object>> expected = Map.of(
        "day", List.of("2020-11-28", "2020-11-28", "2020-12-03", "2020-12-09"),
            "emp_id", List.of(1, 2, 1, 2),
            "total_time", List.of(173, 30, 41, 27)
    );

    @Override
    public void setup(Statement statement) throws Exception {
        statement.execute("RUNSCRIPT FROM 'classpath:/FindTotalTimeSpentByEachEmployee/schema.sql'");
        statement.execute("RUNSCRIPT FROM 'classpath:/FindTotalTimeSpentByEachEmployee/data.sql'");
    }

    @Override
    protected Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("sql/FindTotalTimeSpentByEachEmployee.sql", expected, 4)
        );
    }

}
