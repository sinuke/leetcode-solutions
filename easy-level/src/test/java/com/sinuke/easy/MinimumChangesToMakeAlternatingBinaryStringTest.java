package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumChangesToMakeAlternatingBinaryStringTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minOperations(String s, int expected) {
        var solution = new MinimumChangesToMakeAlternatingBinaryString();
        assertEquals(expected, solution.minOperations(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("0100", 1),
                Arguments.of("10", 0),
                Arguments.of("1111", 2)
        );
    }

}
