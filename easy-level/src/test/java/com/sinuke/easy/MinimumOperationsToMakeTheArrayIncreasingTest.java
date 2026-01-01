package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumOperationsToMakeTheArrayIncreasingTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minOperations(int[] nums, int expected) {
        var solution = new MinimumOperationsToMakeTheArrayIncreasing();
        assertEquals(expected, solution.minOperations(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,1,1}, 3),
                Arguments.of(new int[] {1,5,2,4,1}, 14),
                Arguments.of(new int[] {8}, 0)
        );
    }

}
