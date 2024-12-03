package com.sinuke.sql;

import org.junit.jupiter.params.provider.Arguments;

import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ClassesMoreThanFiveStudentsTest extends SqlTestBase {

    private final Map<String, List<String>> expected = Map.of(
            "class", List.of("Math")
    );

    @Override
    public void setup(Statement statement) throws Exception {
        statement.execute("RUNSCRIPT FROM 'classpath:/ClassesMoreThanFiveStudents/schema.sql'");
        statement.execute("RUNSCRIPT FROM 'classpath:/ClassesMoreThanFiveStudents/data.sql'");
    }

    @Override
    protected Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("sql/ClassesMoreThanFiveStudents.sql", expected, 1)
        );
    }
}
