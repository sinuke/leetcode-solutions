package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordsWithinTwoEditsOfDictionaryTest {

    @ParameterizedTest
    @MethodSource("testData")
    void twoEditWords(String[] queries, String[] dictionary, List<String> expected) {
        var solution = new WordsWithinTwoEditsOfDictionary();
        assertEquals(expected, solution.twoEditWords(queries, dictionary));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new String[] {"word", "note", "ants", "wood"},
                        new String[] {"wood", "joke", "moat"},
                        List.of("word", "note", "wood")
                ),
                Arguments.of(
                        new String[] {"yes"},
                        new String[] {"not"},
                        List.of()
                )
        );
    }

}
