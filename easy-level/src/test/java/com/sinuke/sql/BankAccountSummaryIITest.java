package com.sinuke.sql;

import org.junit.jupiter.params.provider.Arguments;

import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class BankAccountSummaryIITest extends SqlTestBase {

    private final Map<String, List<Object>> expected = Map.of(
            "name", List.of("Alice"),
            "balance", List.of(11000)
    );

    @Override
    public void setup(Statement statement) throws Exception {
        statement.execute("RUNSCRIPT FROM 'classpath:/BankAccountSummaryII/schema.sql'");
        statement.execute("RUNSCRIPT FROM 'classpath:/BankAccountSummaryII/data.sql'");
    }

    @Override
    protected Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("sql/BankAccountSummaryII.sql", expected, 1)
        );
    }

}
