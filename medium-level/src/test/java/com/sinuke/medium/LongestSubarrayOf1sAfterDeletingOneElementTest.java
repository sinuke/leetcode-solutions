package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestSubarrayOf1sAfterDeletingOneElementTest {

    @ParameterizedTest
    @MethodSource("testData")
    void longestSubarray(int[] nums, int expected) {
        var solution = new LongestSubarrayOf1sAfterDeletingOneElement();
        assertEquals(expected, solution.longestSubarray(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,1,0,1}, 3),
                Arguments.of(new int[] {0,1,1,1,0,1,1,0,1}, 5),
                Arguments.of(new int[] {1,1,1}, 2)
        );
    }

}
