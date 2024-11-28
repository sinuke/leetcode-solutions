package com.sinuke.sql;

import org.junit.jupiter.params.provider.Arguments;

import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class TriangleJudgementTest extends SqlTestBase {

    private final Map<String, List<Object>> expected = Map.of(
            "x", List.of(13, 10),
            "y", List.of(15, 20),
            "z", List.of(30, 15),
            "triangle", List.of("No", "Yes")
    );

    @Override
    public void setup(Statement statement) throws Exception {
        statement.execute("RUNSCRIPT FROM 'classpath:/TriangleJudgement/schema.sql'");
        statement.execute("RUNSCRIPT FROM 'classpath:/TriangleJudgement/data.sql'");
    }

    @Override
    protected Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("src/main/sql/TriangleJudgement.sql", expected, 2)
        );
    }

}
