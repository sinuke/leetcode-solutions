package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestContinuousIncreasingSubsequenceTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findLengthOfLCIS(int[] nums, int expected) {
        var solution = new LongestContinuousIncreasingSubsequence();
        assertEquals(expected, solution.findLengthOfLCIS(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,3,5,4,7}, 3),
                Arguments.of(new int[] {2,2,2,2,2}, 1)
        );
    }

}
