package com.sinuke.sql;

import org.junit.jupiter.params.provider.Arguments;

import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ArticleViewsITest extends SqlTestBase {

    private final Map<String, List<Integer>> expected = Map.of(
            "id", List.of(4, 7)
    );

    @Override
    public void setup(Statement statement) throws Exception {
        statement.execute("RUNSCRIPT FROM 'classpath:/ArticleViewsI/schema.sql'");
        statement.execute("RUNSCRIPT FROM 'classpath:/ArticleViewsI/data.sql'");
    }

    @Override
    protected Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("src/main/sql/ArticleViewsI.sql", expected, 2)
        );
    }

}
