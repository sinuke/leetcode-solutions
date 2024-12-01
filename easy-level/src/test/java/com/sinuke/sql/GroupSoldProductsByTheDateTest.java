package com.sinuke.sql;

import org.junit.jupiter.params.provider.Arguments;

import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class GroupSoldProductsByTheDateTest extends SqlTestBase {

    private final Map<String, List<Object>> expected = Map.of(
            "sell_date", List.of("2020-05-30", "2020-06-01", "2020-06-02"),
            "num_sold", List.of(3, 2, 1),
            "products", List.of("Basketball,Headphone,T-Shirt", "Bible,Pencil", "Mask")
    );

    @Override
    public void setup(Statement statement) throws Exception {
        statement.execute("RUNSCRIPT FROM 'classpath:/GroupSoldProductsByTheDate/schema.sql'");
        statement.execute("RUNSCRIPT FROM 'classpath:/GroupSoldProductsByTheDate/data.sql'");
    }

    @Override
    protected Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("src/main/sql/GroupSoldProductsByTheDate.sql", expected, 3)
        );
    }

}
