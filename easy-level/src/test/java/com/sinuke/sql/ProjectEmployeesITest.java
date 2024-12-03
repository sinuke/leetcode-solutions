package com.sinuke.sql;

import org.junit.jupiter.params.provider.Arguments;

import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ProjectEmployeesITest extends SqlTestBase {

    private final Map<String, List<Object>> expected = Map.of(
            "project_id", List.of(1, 2),
            "average_years", List.of(2.00d, 2.50d)
    );

    @Override
    public void setup(Statement statement) throws Exception {
        statement.execute("RUNSCRIPT FROM 'classpath:/ProjectEmployeesI/schema.sql'");
        statement.execute("RUNSCRIPT FROM 'classpath:/ProjectEmployeesI/data.sql'");
    }

    @Override
    protected Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("sql/ProjectEmployeesI.sql", expected, 2)
        );
    }

}
