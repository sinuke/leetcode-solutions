package com.sinuke.sql;

import org.junit.jupiter.params.provider.Arguments;

import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class FindFollowersCountTest extends SqlTestBase {
    
    private final Map<String, List<Integer>> expected = Map.of(
            "user_id", List.of(0, 1, 2),
            "followers_count", List.of(1, 1, 2)
    );
    
    @Override
    public void setup(Statement statement) throws Exception {
        statement.execute("RUNSCRIPT FROM 'classpath:/FindFollowersCount/schema.sql'");
        statement.execute("RUNSCRIPT FROM 'classpath:/FindFollowersCount/data.sql'");
    }

    @Override
    protected Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("sql/FindFollowersCount.sql", expected, 3)
        );
    }
    
}
