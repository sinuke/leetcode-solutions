package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximizeSumOfArrayAfterKNegationsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void largestSumAfterKNegations(int[] nums, int k, int expected) {
        var solution = new MaximizeSumOfArrayAfterKNegations();
        assertEquals(expected, solution.largestSumAfterKNegations(nums, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {4, 2, 3}, 1, 5),
                Arguments.of(new int[] {3, -1, 0, 2}, 3, 6),
                Arguments.of(new int[] {2, -3, -1, 5, -4}, 2, 13)
        );
    }

}
