package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestEvenOddSubarrayWithThresholdTest {

    @ParameterizedTest
    @MethodSource("testData")
    void longestAlternatingSubarray(int[] nums, int threshold, int expected) {
        var solution = new LongestEvenOddSubarrayWithThreshold();
        assertEquals(expected, solution.longestAlternatingSubarray(nums, threshold));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {3, 2, 5, 4}, 5, 3),
                Arguments.of(new int[] {1, 2}, 2, 1),
                Arguments.of(new int[] {2, 3, 4, 5}, 4, 3)
        );
    }

}