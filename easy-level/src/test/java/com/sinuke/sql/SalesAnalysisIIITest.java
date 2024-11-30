package com.sinuke.sql;

import org.junit.jupiter.params.provider.Arguments;

import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class SalesAnalysisIIITest extends SqlTestBase {

    private final Map<String, List<Object>> expected = Map.of(
            "product_id", List.of(1),
            "product_name", List.of("S8")
    );

    @Override
    public void setup(Statement statement) throws Exception {
        statement.execute("RUNSCRIPT FROM 'classpath:/SalesAnalysisIII/schema.sql'");
        statement.execute("RUNSCRIPT FROM 'classpath:/SalesAnalysisIII/data.sql'");
    }

    @Override
    protected Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("src/main/sql/SalesAnalysisIII.sql", expected, 1)
        );
    }

}
