package com.sinuke.sql;

import org.junit.jupiter.params.provider.Arguments;

import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class BigCountriesTest extends SqlTestBase {
    
    private final Map<String, List<Object>> expected = Map.of(
            "name", List.of("Afghanistan", "Algeria"),
            "population", List.of(25500100, 37100000),
            "area", List.of(652230, 2381741)
    );
    
    @Override
    public void setup(Statement statement) throws Exception {
        statement.execute("RUNSCRIPT FROM 'classpath:/BigCountries/schema.sql'");
        statement.execute("RUNSCRIPT FROM 'classpath:/BigCountries/data.sql'");
    }

    @Override
    protected Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("sql/BigCountries.sql", expected, 2)
        );
    }
    
}
