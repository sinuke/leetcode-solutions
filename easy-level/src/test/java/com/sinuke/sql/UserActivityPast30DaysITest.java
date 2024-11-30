package com.sinuke.sql;

import org.junit.jupiter.params.provider.Arguments;

import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class UserActivityPast30DaysITest extends SqlTestBase {

    private final Map<String, List<Object>> expected = Map.of(
            "day", List.of("2019-07-20", "2019-07-21"),
            "active_users", List.of(2, 2)
    );

    @Override
    public void setup(Statement statement) throws Exception {
        statement.execute("RUNSCRIPT FROM 'classpath:/UserActivityPast30DaysI/schema.sql'");
        statement.execute("RUNSCRIPT FROM 'classpath:/UserActivityPast30DaysI/data.sql'");
    }

    @Override
    protected Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("src/main/sql/UserActivityPast30DaysI.sql", expected, 2)
        );
    }

}
