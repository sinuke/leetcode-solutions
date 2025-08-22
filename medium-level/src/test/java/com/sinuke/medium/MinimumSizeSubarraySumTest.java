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
                Arguments.of(11, new int[] {1,1,1,1,1,1,1,1}, 0),
                Arguments.of(11, new int[] {1,2,3,4,5}, 3),
                Arguments.of(15, new int[] {1,2,3,4,5}, 5),
                Arguments.of(15, new int[] {5,1,3,5,10,7,4,9,2,8}, 2),
                Arguments.of(80, new int[] {10,5,13,4,8,4,5,11,14,9,16,10,20,8}, 6)
        );
    }

}