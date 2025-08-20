package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumSizeSubarraySumTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minSubArrayLen(int target, int[] nums, int expected) {
        var solution = new MinimumSizeSubarraySum();
        assertEquals(expected, solution.minSubArrayLen(target, nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(7, new int[] {2,3,1,2,4,3}, 2),
                Arguments.of(4, new int[] {1,4,4}, 1),
                Arguments.of(11, new int[] {1,1,1,1,1,1,1,1}, 0)
        );
    }

}