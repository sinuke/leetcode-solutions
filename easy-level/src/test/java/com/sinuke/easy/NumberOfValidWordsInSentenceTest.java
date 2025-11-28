package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfValidWordsInSentenceTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countValidWords(String sentence, int expected) {
        var solution = new NumberOfValidWordsInSentence();
        assertEquals(expected, solution.countValidWords(sentence));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("cat and  dog", 3),
                Arguments.of("!this  1-s b8d!", 0),
                Arguments.of("alice and  bob are playing stone-game10", 5),
                Arguments.of(".", 1)
        );
    }

}
