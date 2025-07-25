package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountTheNumberOfSpecialCharactersITest {

    @ParameterizedTest
    @MethodSource("testData")
    void numberOfSpecialChars(String word, int expected) {
        var solution = new CountTheNumberOfSpecialCharactersI();
        assertEquals(expected, solution.numberOfSpecialChars(word));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("aaAbcBC", 3),
                Arguments.of("abc", 0),
                Arguments.of("abBCab", 1)
        );
    }

}
