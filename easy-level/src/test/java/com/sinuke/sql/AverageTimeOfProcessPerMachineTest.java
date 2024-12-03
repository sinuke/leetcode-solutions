package com.sinuke.sql;

import org.junit.jupiter.params.provider.Arguments;

import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class AverageTimeOfProcessPerMachineTest extends SqlTestBase {

    private final Map<String, List<Object>> expected = Map.of(
            "machine_id", List.of(0, 1, 2),
            "processing_time", List.of(0.894d, 0.995d, 1.456d)
    );

    @Override
    public void setup(Statement statement) throws Exception {
        statement.execute("RUNSCRIPT FROM 'classpath:/AverageTimeOfProcessPerMachine/schema.sql'");
        statement.execute("RUNSCRIPT FROM 'classpath:/AverageTimeOfProcessPerMachine/data.sql'");
    }

    @Override
    protected Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("src/main/sql/AverageTimeOfProcessPerMachine.sql", expected, 3)
        );
    }

}
