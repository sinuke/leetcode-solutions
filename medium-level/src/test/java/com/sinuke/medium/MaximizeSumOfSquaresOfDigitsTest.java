package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximizeSumOfSquaresOfDigitsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maxSumOfSquares(int num, int sum, String expected) {
        var solution = new MaximizeSumOfSquaresOfDigits();
        assertEquals(expected, solution.maxSumOfSquares(num, sum));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(2, 3, "30"),
                Arguments.of(2, 17, "98"),
                Arguments.of(1, 10, "")
        );
    }

}
