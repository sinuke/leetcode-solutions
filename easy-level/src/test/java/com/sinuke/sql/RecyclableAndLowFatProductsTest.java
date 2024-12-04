package com.sinuke.sql;

import org.junit.jupiter.params.provider.Arguments;

import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class RecyclableAndLowFatProductsTest extends SqlTestBase {

    private final Map<String, List<Integer>> expected = Map.of(
            "product_id", List.of(1, 3)
    );

    @Override
    public void setup(Statement statement) throws Exception {
        statement.execute("RUNSCRIPT FROM 'classpath:/RecyclableAndLowFatProducts/schema.sql'");
        statement.execute("RUNSCRIPT FROM 'classpath:/RecyclableAndLowFatProducts/data.sql'");
    }

    @Override
    protected Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("sql/RecyclableAndLowFatProducts.sql", expected, 2)
        );
    }

}
