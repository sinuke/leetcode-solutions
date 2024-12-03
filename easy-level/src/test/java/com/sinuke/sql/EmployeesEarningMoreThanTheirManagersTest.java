package com.sinuke.sql;

import org.junit.jupiter.params.provider.Arguments;

import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class EmployeesEarningMoreThanTheirManagersTest extends SqlTestBase {
    
    private final Map<String, List<String>> expected = Map.of(
        "Employee", List.of("Joe")
    );
    
    @Override
    public void setup(Statement statement) throws Exception {
        statement.execute("RUNSCRIPT FROM 'classpath:/EmployeesEarningMoreThanTheirManagers/schema.sql'");
        statement.execute("RUNSCRIPT FROM 'classpath:/EmployeesEarningMoreThanTheirManagers/data.sql'");
    }

    @Override
    protected Stream<Arguments> testData() {
        return Stream.of(
            Arguments.of("sql/EmployeesEarningMoreThanTheirManagers.sql", expected, 1)
        );
    }
    
}
