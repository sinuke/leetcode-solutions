package com.sinuke.sql;

import org.junit.jupiter.params.provider.Arguments;

import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class InvalidTweetsTest extends SqlTestBase {

    private final Map<String, List<Integer>> expected = Map.of(
            "tweet_id", List.of(2)
    );

    @Override
    public void setup(Statement statement) throws Exception {
        statement.execute("RUNSCRIPT FROM 'classpath:/InvalidTweets/schema.sql'");
        statement.execute("RUNSCRIPT FROM 'classpath:/InvalidTweets/data.sql'");
    }

    @Override
    protected Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("src/main/sql/InvalidTweets.sql", expected, 1)
        );
    }

}
