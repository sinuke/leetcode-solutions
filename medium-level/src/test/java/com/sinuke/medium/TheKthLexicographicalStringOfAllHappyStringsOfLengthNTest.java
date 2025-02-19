package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TheKthLexicographicalStringOfAllHappyStringsOfLengthNTest {

    @ParameterizedTest
    @MethodSource("testData")
    void getHappyString(int n, int k, String expected) {
        var solution = new TheKthLexicographicalStringOfAllHappyStringsOfLengthN();
        assertEquals(expected, solution.getHappyString(n, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(1, 3, "c"),
                Arguments.of(1, 4, ""),
                Arguments.of(3, 9, "cab")
        );
    }

}
