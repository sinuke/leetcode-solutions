package com.sinuke.sql;

import org.junit.jupiter.params.provider.Arguments;

import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class EmployeeBonusTest extends SqlTestBase {
    
    private final Map<String, List<Object>> expected = Map.of(
            "name", List.of("Brad", "John", "Dan"),
            "bonus", Arrays.asList(null, null, 500)
    );
    
    @Override
    public void setup(Statement statement) throws Exception {
        statement.execute("RUNSCRIPT FROM 'classpath:/EmployeeBonus/schema.sql'");
        statement.execute("RUNSCRIPT FROM 'classpath:/EmployeeBonus/data.sql'");
    }

    @Override
    protected Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("sql/EmployeeBonus.sql", expected, 3)
        );
    }
    
}
