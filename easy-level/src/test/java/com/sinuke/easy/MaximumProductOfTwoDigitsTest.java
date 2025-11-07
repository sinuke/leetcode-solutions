package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumProductOfTwoDigitsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maxProduct(int n, int expected) {
        var solution = new MaximumProductOfTwoDigits();
        assertEquals(expected, solution.maxProduct(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(31, 3),
                Arguments.of(22, 4),
                Arguments.of(124, 8)
        );
    }

}
