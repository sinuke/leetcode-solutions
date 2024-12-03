package com.sinuke.sql;

import org.junit.jupiter.params.provider.Arguments;

import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class BiggestSingleNumberTest extends SqlTestBase {

    private final Map<String, List<Integer>> expected = Map.of(
            "num", List.of(6)
    );

    @Override
    public void setup(Statement statement) throws Exception {
        statement.execute("RUNSCRIPT FROM 'classpath:/BiggestSingleNumber/schema.sql'");
        statement.execute("RUNSCRIPT FROM 'classpath:/BiggestSingleNumber/data.sql'");
    }

    @Override
    protected Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("sql/BiggestSingleNumber.sql", expected, 1)
        );
    }

}
