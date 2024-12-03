package com.sinuke.sql;

import org.junit.jupiter.params.provider.Arguments;

import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class PercentageOfUsersAttendedContestTest extends SqlTestBase {

    private final Map<String, List<Object>> expected = Map.of(
            "contest_id", List.of(208, 209, 210, 215, 207),
            "percentage", List.of(100.0d, 100.0d, 100.0d, 66.67d, 33.33d)
    );

    @Override
    public void setup(Statement statement) throws Exception {
        statement.execute("RUNSCRIPT FROM 'classpath:/PercentageOfUsersAttendedContest/schema.sql'");
        statement.execute("RUNSCRIPT FROM 'classpath:/PercentageOfUsersAttendedContest/data.sql'");
    }

    @Override
    protected Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("src/main/sql/PercentageOfUsersAttendedContest.sql", expected, 5)
        );
    }

}
