package com.sinuke.sql;

import org.junit.jupiter.params.provider.Arguments;

import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ActorsDirectorsWhoCooperatedAtLeastThreeTimesTest extends SqlTestBase {

    private final Map<String, List<Integer>> expected = Map.of(
            "actor_id", List.of(1),
            "director_id", List.of(1)
    );

    @Override
    public void setup(Statement statement) throws Exception {
        statement.execute("RUNSCRIPT FROM 'classpath:/ActorsDirectorsWhoCooperatedAtLeastThreeTimes/schema.sql'");
        statement.execute("RUNSCRIPT FROM 'classpath:/ActorsDirectorsWhoCooperatedAtLeastThreeTimes/data.sql'");
    }

    @Override
    protected Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("src/main/sql/ActorsDirectorsWhoCooperatedAtLeastThreeTimes.sql", expected, 1)
        );
    }

}
