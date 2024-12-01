package com.sinuke.sql;

import org.junit.jupiter.params.provider.Arguments;

import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class QueriesQualityPercentageTest extends SqlTestBase {

    private final Map<String, List<Object>> expected = Map.of(
            "query_name", List.of("Cat", "Dog"),
            "quality", List.of(0.66d, 2.5d),
            "poor_query_percentage", List.of(33.33d, 33.33d)
    );

    @Override
    public void setup(Statement statement) throws Exception {
        statement.execute("RUNSCRIPT FROM 'classpath:/QueriesQualityPercentage/schema.sql'");
        statement.execute("RUNSCRIPT FROM 'classpath:/QueriesQualityPercentage/data.sql'");
    }

    @Override
    protected Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("src/main/sql/QueriesQualityPercentage.sql", expected, 2)
        );
    }

}
