package com.sinuke.sql;

import org.junit.jupiter.params.provider.Arguments;

import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class PatientsWithConditionTest extends SqlTestBase {

    private final Map<String, List<Object>> expected = Map.of(
            "patient_id", List.of(3, 4),
            "patient_name", List.of("Bob", "George"),
            "conditions", List.of("DIAB100 MYOP", "ACNE DIAB100")
    );

    @Override
    public void setup(Statement statement) throws Exception {
        statement.execute("RUNSCRIPT FROM 'classpath:/PatientsWithCondition/schema.sql'");
        statement.execute("RUNSCRIPT FROM 'classpath:/PatientsWithCondition/data.sql'");
    }

    @Override
    protected Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("sql/PatientsWithCondition.sql", expected, 2)
        );
    }

}
