package com.sinuke.sql;

import org.junit.jupiter.params.provider.Arguments;

import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class DailyLeadsAndPartnersTest extends SqlTestBase {

    private final Map<String, List<Object>> expected = Map.of(
            "date_id", List.of("2020-12-07", "2020-12-07", "2020-12-08", "2020-12-08"),
            "make_name", List.of("honda", "toyota", "honda", "toyota"),
            "unique_leads", List.of(3, 1, 2, 2),
            "unique_partners", List.of(2, 2, 2, 3)
    );

    @Override
    public void setup(Statement statement) throws Exception {
        statement.execute("RUNSCRIPT FROM 'classpath:/DailyLeadsAndPartners/schema.sql'");
        statement.execute("RUNSCRIPT FROM 'classpath:/DailyLeadsAndPartners/data.sql'");
    }

    @Override
    protected Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("sql/DailyLeadsAndPartners.sql", expected, 4)
        );
    }

}
