package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumLengthSubstringWithTwoOccurrencesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maximumLengthSubstring(String s, int expected) {
        var solution = new MaximumLengthSubstringWithTwoOccurrences();
        assertEquals(expected, solution.maximumLengthSubstring(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("bcbbbcba", 4),
                Arguments.of("aaaa", 2)
        );
    }

}
