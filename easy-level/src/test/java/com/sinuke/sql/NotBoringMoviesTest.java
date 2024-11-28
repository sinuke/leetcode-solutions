package com.sinuke.sql;

import org.junit.jupiter.params.provider.Arguments;

import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class NotBoringMoviesTest extends SqlTestBase {

    private final Map<String, List<Object>> expected = Map.of(
            "id", List.of(5, 1),
            "movie", List.of("House card", "War"),
            "description", List.of("Interesting", "great 3D"),
            "rating", List.of(9.1f, 8.9f)
    );

    @Override
    public void setup(Statement statement) throws Exception {
        statement.execute("RUNSCRIPT FROM 'classpath:/NotBoringMovies/schema.sql'");
        statement.execute("RUNSCRIPT FROM 'classpath:/NotBoringMovies/data.sql'");
    }

    @Override
    protected Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("src/main/sql/NotBoringMovies.sql", expected, 2)
        );
    }

}
