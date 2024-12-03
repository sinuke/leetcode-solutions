package com.sinuke.sql;

import org.junit.jupiter.params.provider.Arguments;

import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class FindCustomerRefereeTest extends SqlTestBase {
    
    private final Map<String, List<String>> expected = Map.of(
            "name", List.of("Will", "Jane", "Bill", "Zack")
    );
    
    @Override
    public void setup(Statement statement) throws Exception {
        statement.execute("RUNSCRIPT FROM 'classpath:/FindCustomerReferee/schema.sql'");
        statement.execute("RUNSCRIPT FROM 'classpath:/FindCustomerReferee/data.sql'");
    }

    @Override
    protected Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("sql/FindCustomerReferee.sql", expected, 4)
        );
    }
    
}
