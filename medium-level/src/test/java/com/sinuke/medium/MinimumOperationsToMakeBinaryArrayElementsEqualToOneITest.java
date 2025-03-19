package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumOperationsToMakeBinaryArrayElementsEqualToOneITest {

    @ParameterizedTest
    @MethodSource("testData")
    void minOperations(int[] nums, int expected) {
        var solution = new MinimumOperationsToMakeBinaryArrayElementsEqualToOneI();
        assertEquals(expected, solution.minOperations(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {0,1,1,1,0,0}, 3),
                Arguments.of(new int[] {0,1,1,1}, -1),
                Arguments.of(new int[] {0,0,0}, 1)
        );
    }

}
