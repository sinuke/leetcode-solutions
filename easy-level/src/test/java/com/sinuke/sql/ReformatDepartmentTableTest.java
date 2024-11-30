package com.sinuke.sql;

import org.junit.jupiter.params.provider.Arguments;

import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ReformatDepartmentTableTest extends SqlTestBase {

    private final Map<String, List<Integer>> expected = Map.ofEntries(
            Map.entry("id", List.of(1, 2, 3)),
            Map.entry("Jan_Revenue", Arrays.asList(8000, 9000, null)),
            Map.entry("Feb_Revenue", Arrays.asList(7000, null, 10000)),
            Map.entry("Mar_Revenue", Arrays.asList(6000, null, null)),
            Map.entry("Apr_Revenue", Arrays.asList(null, null, null)),
            Map.entry("May_Revenue", Arrays.asList(null, null, null)),
            Map.entry("Jun_Revenue", Arrays.asList(null, null, null)),
            Map.entry("Jul_Revenue", Arrays.asList(null, null, null)),
            Map.entry("Aug_Revenue", Arrays.asList(null, null, null)),
            Map.entry("Sep_Revenue", Arrays.asList(null, null, null)),
            Map.entry("Oct_Revenue", Arrays.asList(null, null, null)),
            Map.entry("Nov_Revenue", Arrays.asList(null, null, null)),
            Map.entry("Dec_Revenue", Arrays.asList(null, null, null))
    );

    @Override
    public void setup(Statement statement) throws Exception {
        statement.execute("RUNSCRIPT FROM 'classpath:/ReformatDepartmentTable/schema.sql'");
        statement.execute("RUNSCRIPT FROM 'classpath:/ReformatDepartmentTable/data.sql'");
    }

    @Override
    protected Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("src/main/sql/ReformatDepartmentTable.sql", expected, 3)
        );
    }

}
