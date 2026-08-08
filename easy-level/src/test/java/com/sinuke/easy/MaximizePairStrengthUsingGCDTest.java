package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximizePairStrengthUsingGCDTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maxPairStrength(int[] nums, long expected) {
        var solution = new MaximizePairStrengthUsingGCD();
        assertEquals(expected, solution.maxPairStrength(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{2, 3, 5}, 15L),
                Arguments.of(new int[]{4, 6, 8}, 12L),
                Arguments.of(new int[]{3, 3}, 1L)
        );
    }

}
