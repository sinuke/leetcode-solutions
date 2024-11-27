package com.sinuke.sql;

import org.junit.jupiter.params.provider.Arguments;

import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class GamePlayAnalysisITest extends SqlTestBase {

    private final Map<String, List<Object>> expected = Map.of(
            "player_id", List.of(1, 2, 3),
            "first_login", List.of("2016-03-01", "2017-06-25", "2016-03-02")
    );

    @Override
    public void setup(Statement statement) throws Exception {
        statement.execute("RUNSCRIPT FROM 'classpath:/GamePlayAnalysisI/schema.sql'");
        statement.execute("RUNSCRIPT FROM 'classpath:/GamePlayAnalysisI/data.sql'");
    }

    @Override
    protected Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("src/main/sql/GamePlayAnalysisI.sql", expected, 3)
        );
    }
}
