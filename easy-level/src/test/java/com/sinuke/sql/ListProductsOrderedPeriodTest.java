package com.sinuke.sql;

import org.junit.jupiter.params.provider.Arguments;

import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ListProductsOrderedPeriodTest extends SqlTestBase {

    private final Map<String, List<Object>> expected = Map.of(
            "product_name", List.of("Leetcode Solutions", "Leetcode Kit"),
            "unit", List.of(130, 100)
    );

    @Override
    public void setup(Statement statement) throws Exception {
        statement.execute("RUNSCRIPT FROM 'classpath:/ListProductsOrderedPeriod/schema.sql'");
        statement.execute("RUNSCRIPT FROM 'classpath:/ListProductsOrderedPeriod/data.sql'");
    }

    @Override
    protected Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("src/main/sql/ListProductsOrderedPeriod.sql", expected, 2)
        );
    }

}
