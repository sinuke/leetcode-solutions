package com.sinuke.sql;

import org.junit.jupiter.params.provider.Arguments;

import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class RisingTemperatureTest extends SqlTestBase {

    private final Map<String, List<Integer>> expected = Map.of(
            "id", List.of(2, 4)
    );

    @Override
    public void setup(Statement statement) throws Exception {
        statement.execute("RUNSCRIPT FROM 'classpath:/RisingTemperature/schema.sql'");
        statement.execute("RUNSCRIPT FROM 'classpath:/RisingTemperature/data.sql'");
    }

    @Override
    protected Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("sql/RisingTemperature.sql", expected, 2)
        );
    }

}
