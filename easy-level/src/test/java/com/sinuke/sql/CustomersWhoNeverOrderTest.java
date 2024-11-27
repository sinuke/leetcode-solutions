package com.sinuke.sql;

import org.junit.jupiter.params.provider.Arguments;

import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class CustomersWhoNeverOrderTest extends SqlTestBase {

    private final Map<String, List<String>> expected = Map.of(
            "Customers", List.of("Henry", "Max")
    );

    @Override
    public void setup(Statement statement) throws Exception {
        statement.execute("RUNSCRIPT FROM 'classpath:/CustomersWhoNeverOrder/schema.sql'");
        statement.execute("RUNSCRIPT FROM 'classpath:/CustomersWhoNeverOrder/data.sql'");
    }

    @Override
    protected Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("src/main/sql/CustomersWhoNeverOrder.sql", expected, 1)
        );
    }

}
