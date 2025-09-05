package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PowXNTest {

    @ParameterizedTest
    @MethodSource("testData")
    void myPow(double x, int n, double expected) {
        var solution = new PowXN();
        assertEquals(expected, solution.myPow(x, n), 0.000001);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(2.00000, 10, 1024.00000),
                Arguments.of(2.10000, 3, 9.26100),
                Arguments.of(2.00000, -2, 0.25000),
                Arguments.of(-1, 2147483647, -1.00000),
                Arguments.of(1, -2147483648, 1.00000)
        );
    }

}
