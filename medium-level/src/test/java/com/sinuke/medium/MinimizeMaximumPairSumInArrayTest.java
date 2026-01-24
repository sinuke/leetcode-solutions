package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimizeMaximumPairSumInArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minPairSum(int[] nums, int expected) {
        var solution = new MinimizeMaximumPairSumInArray();
        assertEquals(expected, solution.minPairSum(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {3,5,2,3}, 7),
                Arguments.of(new int[] {3,5,4,2,4,6}, 8)
        );
    }

}
