package com.sinuke.sql;

import org.junit.jupiter.params.provider.Arguments;

import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class FindUsersWithValidEMailsTest extends SqlTestBase {

    private final Map<String, List<Object>> expected = Map.of(
            "user_id", List.of(1, 3, 4),
            "name", List.of("Winston", "Annabelle", "Sally"),
            "mail", List.of("winston@leetcode.com", "bella-@leetcode.com", "sally.come@leetcode.com")
    );

    @Override
    public void setup(Statement statement) throws Exception {
        statement.execute("RUNSCRIPT FROM 'classpath:/FindUsersWithValidEMails/schema.sql'");
        statement.execute("RUNSCRIPT FROM 'classpath:/FindUsersWithValidEMails/data.sql'");
    }

    @Override
    protected Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("src/main/sql/FindUsersWithValidEMails.sql", expected, 3)
        );
    }

}
