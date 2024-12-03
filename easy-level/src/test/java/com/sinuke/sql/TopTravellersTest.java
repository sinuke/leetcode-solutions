package com.sinuke.sql;

import org.junit.jupiter.params.provider.Arguments;

import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class TopTravellersTest extends SqlTestBase {

    private final Map<String, List<Object>> expected = Map.of(
            "name", List.of("Elvis", "Lee", "Bob", "Jonathan", "Alex", "Alice"),
            "travelled_distance", List.of(450, 450, 317, 312, 222, 120)
    );

    @Override
    public void setup(Statement statement) throws Exception {
        statement.execute("RUNSCRIPT FROM 'classpath:/TopTravellers/schema.sql'");
        statement.execute("RUNSCRIPT FROM 'classpath:/TopTravellers/data.sql'");
    }

    @Override
    protected Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("sql/TopTravellers.sql", expected, 6)
        );
    }

}
