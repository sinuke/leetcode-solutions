package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumOperationsToMakeArraySumDivisibleByKTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minOperations(int[] nums, int k, int expected) {
        var solution = new MinimumOperationsToMakeArraySumDivisibleByK();
        assertEquals(expected, solution.minOperations(nums, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {3,9,7}, 5, 4),
                Arguments.of(new int[] {4,1,3}, 4, 0),
                Arguments.of(new int[] {3,2}, 6, 5)
        );
    }

}
