package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumAscendingSubarraySumTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maxAscendingSum(int[] nums, int expected) {
        var maxAscendingSubarraySum = new MaximumAscendingSubarraySum();
        assertEquals(expected, maxAscendingSubarraySum.maxAscendingSum(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {10,20,30,5,10,50}, 65),
                Arguments.of(new int[] {10,20,30,40,50}, 150),
                Arguments.of(new int[] {12,17,15,13,10,11,12}, 33)
        );
    }

}
