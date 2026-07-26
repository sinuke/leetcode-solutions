package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LargestIntegerWithGivenDigitSumTest {

    @ParameterizedTest
    @MethodSource("testData")
    void largestInteger(int n, int s, int expected) {
        var solution = new LargestIntegerWithGivenDigitSum();
        assertEquals(expected, solution.largestInteger(n, s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(2, 9, 90),
                Arguments.of(2, 19, -1),
                Arguments.of(5, 0, 0)
        );
    }

}
