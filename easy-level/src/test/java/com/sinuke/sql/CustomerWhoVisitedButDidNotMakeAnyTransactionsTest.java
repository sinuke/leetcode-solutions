package com.sinuke.sql;

import org.junit.jupiter.params.provider.Arguments;

import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class CustomerWhoVisitedButDidNotMakeAnyTransactionsTest extends SqlTestBase {

    private final Map<String, List<Integer>> expected = Map.of(
            "customer_id", List.of(30, 96, 54),
            "count_no_trans", List.of(1, 1, 2)
    );

    @Override
    public void setup(Statement statement) throws Exception {
        statement.execute("RUNSCRIPT FROM 'classpath:/CustomerWhoVisitedButDidNotMakeAnyTransactions/schema.sql'");
        statement.execute("RUNSCRIPT FROM 'classpath:/CustomerWhoVisitedButDidNotMakeAnyTransactions/data.sql'");
    }

    @Override
    protected Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("src/main/sql/CustomerWhoVisitedButDidNotMakeAnyTransactions.sql", expected, 2)
        );
    }

}
