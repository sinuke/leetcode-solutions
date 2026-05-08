package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumOperationsToMakeArrayValuesEqualToKTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minOperations(int[] nums, int k, int expected) {
        var solution = new MinimumOperationsToMakeArrayValuesEqualToK();
        assertEquals(expected, solution.minOperations(nums, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {5, 2, 5, 4, 5}, 2, 2),
                Arguments.of(new int[] {2, 1, 2}, 2, -1),
                Arguments.of(new int[] {9, 7, 5, 3}, 1, 4),
                Arguments.of(new int[] {5, 5, 5, 5, 5}, 5, 0),
                Arguments.of(new int[] {2}, 1, 1)
        );
    }

}
