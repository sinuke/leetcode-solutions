package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumDifferenceByRemappingDigitTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minMaxDifference(int num, int expected) {
        var solution = new MaximumDifferenceByRemappingDigit();
        assertEquals(expected, solution.minMaxDifference(num));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(11891, 99009),
                Arguments.of(90, 99)
        );
    }

}
