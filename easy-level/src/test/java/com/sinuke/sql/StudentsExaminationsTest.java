package com.sinuke.sql;

import org.junit.jupiter.params.provider.Arguments;

import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class StudentsExaminationsTest extends SqlTestBase {

    private final Map<String, List<Object>> expected = Map.of(
            "student_id", List.of(1, 1, 1, 2, 2, 2, 6, 6, 6, 13, 13, 13),
            "student_name", List.of("Alice", "Alice", "Alice", "Bob", "Bob", "Bob", "Alex", "Alex", "Alex", "John", "John", "John"),
            "subject_name", List.of("Math", "Physics", "Programming", "Math", "Physics", "Programming", "Math", "Physics", "Programming", "Math", "Physics", "Programming"),
            "attended_exams", List.of(3, 2, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1)
    );

    @Override
    public void setup(Statement statement) throws Exception {
        statement.execute("RUNSCRIPT FROM 'classpath:/StudentsExaminations/schema.sql'");
        statement.execute("RUNSCRIPT FROM 'classpath:/StudentsExaminations/data.sql'");
    }

    @Override
    protected Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("src/main/sql/StudentsExaminations.sql", expected, 12)
        );
    }

}
