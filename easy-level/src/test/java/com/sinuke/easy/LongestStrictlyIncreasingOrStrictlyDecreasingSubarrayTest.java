package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestStrictlyIncreasingOrStrictlyDecreasingSubarrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void longestMonotonicSubarray(int[] nums, int expected) {
        var longest = new LongestStrictlyIncreasingOrStrictlyDecreasingSubarray();
        assertEquals(expected, longest.longestMonotonicSubarray(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,4,3,3,2}, 2),
                Arguments.of(new int[] {3,3,3,3}, 1),
                Arguments.of(new int[] {3,2,1}, 3)
        );
    }

}
