package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumUniqueSubarraySumAfterDeletionTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maxSum(int[] nums, int expected) {
        var solution = new MaximumUniqueSubarraySumAfterDeletion();
        assertEquals(expected, solution.maxSum(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1, 2, 3, 4, 5}, 15),
                Arguments.of(new int[] {1, 1, 0, 1, 1}, 1),
                Arguments.of(new int[] {1, 2, -1, -2, 1, 0, -1}, 3)
        );
    }

}
