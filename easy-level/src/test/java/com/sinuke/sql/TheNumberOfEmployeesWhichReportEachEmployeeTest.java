package com.sinuke.sql;

import org.junit.jupiter.params.provider.Arguments;

import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class TheNumberOfEmployeesWhichReportEachEmployeeTest extends SqlTestBase {
    
    private final Map<String, List<Object>> expected = Map.of(
            "employee_id", List.of(9),
            "name", List.of("Hercy"),
            "reports_count", List.of(2),
            "average_age", List.of(39)
    );
    
    @Override
    public void setup(Statement statement) throws Exception {
        statement.execute("RUNSCRIPT FROM 'classpath:/TheNumberOfEmployeesWhichReportEachEmployee/schema.sql'");
        statement.execute("RUNSCRIPT FROM 'classpath:/TheNumberOfEmployeesWhichReportEachEmployee/data.sql'");
    }

    @Override
    protected Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("sql/TheNumberOfEmployeesWhichReportEachEmployee.sql", expected, 1)
        );
    }
}
