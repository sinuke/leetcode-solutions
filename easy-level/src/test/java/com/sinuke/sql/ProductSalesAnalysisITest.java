package com.sinuke.sql;

import org.junit.jupiter.params.provider.Arguments;

import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ProductSalesAnalysisITest extends SqlTestBase {

    private final Map<String, List<Object>> expected = Map.of(
            "product_name", List.of("Nokia", "Nokia", "Apple"),
            "year", List.of(2008, 2009, 2011),
            "price", List.of(5000, 5000, 9000)
    );

    @Override
    public void setup(Statement statement) throws Exception {
        statement.execute("RUNSCRIPT FROM 'classpath:/ProductSalesAnalysisI/schema.sql'");
        statement.execute("RUNSCRIPT FROM 'classpath:/ProductSalesAnalysisI/data.sql'");
    }

    @Override
    protected Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("src/main/sql/ProductSalesAnalysisI.sql", expected, 3)
        );
    }

}
