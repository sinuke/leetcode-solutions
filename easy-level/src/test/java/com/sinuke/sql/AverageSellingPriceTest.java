package com.sinuke.sql;

import org.junit.jupiter.params.provider.Arguments;

import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class AverageSellingPriceTest extends SqlTestBase {

    private final Map<String, List<Object>> expected = Map.of(
            "product_id", List.of(1, 2),
            "average_price", List.of(6.96d, 16.96d)
    );

    @Override
    public void setup(Statement statement) throws Exception {
        statement.execute("RUNSCRIPT FROM 'classpath:/AverageSellingPrice/schema.sql'");
        statement.execute("RUNSCRIPT FROM 'classpath:/AverageSellingPrice/data.sql'");
    }

    @Override
    protected Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("sql/AverageSellingPrice.sql", expected, 2)
        );
    }

}
