package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThreeFibonacciSumTest {

    @ParameterizedTest
    @MethodSource("testData")
    void threeFibonacciSum(int n, boolean expected) {
        var solution = new ThreeFibonacciSum();
        assertEquals(expected, solution.threeFibonacciSum(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(16, true),
                Arguments.of(8, false),
                Arguments.of(2, true)
        );
    }

}
