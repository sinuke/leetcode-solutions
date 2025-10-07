package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReplaceWordsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void replaceWords(List<String> dictionary, String sentence, String expected) {
        var solution = new ReplaceWords();
        assertEquals(expected, solution.replaceWords(dictionary, sentence));
        assertEquals(expected, solution.replaceWords2(dictionary, sentence));
        assertEquals(expected, solution.replaceWords3(dictionary, sentence));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(List.of("cat","bat","rat"), "the cattle was rattled by the battery", "the cat was rat by the bat"),
                Arguments.of(List.of("a","b","c"), "aadsfasf absbs bbab cadsfafs", "a a b c")
        );
    }

}
