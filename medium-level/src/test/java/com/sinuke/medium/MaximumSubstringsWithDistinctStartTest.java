package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumSubstringsWithDistinctStartTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maxDistinct(String s, int expected) {
        var solution = new MaximumSubstringsWithDistinctStart();
        assertEquals(expected, solution.maxDistinct(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("abab", 2),
                Arguments.of("abcd", 4),
                Arguments.of("aaaa", 1)
        );
    }

}
