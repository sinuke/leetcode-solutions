package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumOperationsToEqualizeArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minOperations(int[] nums, int expected) {
        var solution = new MinimumOperationsToEqualizeArray();
        assertEquals(expected, solution.minOperations(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,2}, 1),
                Arguments.of(new int[] {5,5,5}, 0)
        );
    }

}
