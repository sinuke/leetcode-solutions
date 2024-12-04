package com.sinuke.sql;

import org.junit.jupiter.params.provider.Arguments;

import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class RearrangeProductsTableTest extends SqlTestBase {

    private final Map<String, List<Object>> expected = Map.of(
            "product_id", List.of(0, 0, 0, 1, 1),
            "store", List.of("store1", "store2", "store3", "store1", "store3"),
            "price", List.of(95, 100, 105, 70, 80)
    );

    @Override
    public void setup(Statement statement) throws Exception {
        statement.execute("RUNSCRIPT FROM 'classpath:/RearrangeProductsTable/schema.sql'");
        statement.execute("RUNSCRIPT FROM 'classpath:/RearrangeProductsTable/data.sql'");
    }

    @Override
    protected Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("sql/RearrangeProductsTable.sql", expected, 5)
        );
    }

}
