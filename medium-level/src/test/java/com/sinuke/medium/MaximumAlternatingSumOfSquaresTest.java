package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumAlternatingSumOfSquaresTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maxAlternatingSum(int[] nums, long expected) {
        var solution = new MaximumAlternatingSumOfSquares();
        assertEquals(expected, solution.maxAlternatingSum(Arrays.copyOf(nums, nums.length)));
        assertEquals(expected, solution.maxAlternatingSum2(Arrays.copyOf(nums, nums.length)));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, 12L),
                Arguments.of(new int[]{1, -1, 2, -2, 3, -3}, 16L)
        );
    }

}
