package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NthTribonacciNumberTest {

    @ParameterizedTest
    @MethodSource("testData")
    void tribonacci(int n, int expected) {
        var solution = new NthTribonacciNumber();
        assertEquals(expected, solution.tribonacci(n));
        assertEquals(expected, solution.tribonacci2(n));
        assertEquals(expected, solution.tribonacci3(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(4, 4),
                Arguments.of(25, 1389537)
        );
    }

}
