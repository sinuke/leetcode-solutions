package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FibonacciNumberTest {

    @ParameterizedTest
    @MethodSource("testData")
    void fib(int n, int expected) {
        var fibonacciNumber = new FibonacciNumber();
        assertEquals(expected, fibonacciNumber.fib(n));
        assertEquals(expected, fibonacciNumber.fib2(n));
        assertEquals(expected, fibonacciNumber.fib3(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(2, 1),
                Arguments.of(3, 2),
                Arguments.of(4, 3),
                Arguments.of(30, 832040)
        );
    }

}
