package com.sinuke.sql;

import org.junit.jupiter.params.provider.Arguments;

import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class CustomerPlacingTheLargestNumberOfOrdersTest extends SqlTestBase {
    
    private final Map<String, List<Integer>> expected = Map.of(
            "customer_number", List.of(3)
    );
    
    @Override
    public void setup(Statement statement) throws Exception {
        statement.execute("RUNSCRIPT FROM 'classpath:/CustomerPlacingTheLargestNumberOfOrders/schema.sql'");
        statement.execute("RUNSCRIPT FROM 'classpath:/CustomerPlacingTheLargestNumberOfOrders/data.sql'");
    }

    @Override
    protected Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("src/main/sql/CustomerPlacingTheLargestNumberOfOrders.sql", expected, 1)
        );
    }
    
}
