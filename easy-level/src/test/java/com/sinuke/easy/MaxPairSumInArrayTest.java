package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxPairSumInArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maxSum(int[] nums, int expected) {
        var solution = new MaxPairSumInArray();
        assertEquals(expected, solution.maxSum(nums));
        assertEquals(expected, solution.maxSum2(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {112,131,411}, -1),
                Arguments.of(new int[] {2536,1613,3366,162}, 5902),
                Arguments.of(new int[] {51,71,17,24,42}, 88)
        );
    }

}
