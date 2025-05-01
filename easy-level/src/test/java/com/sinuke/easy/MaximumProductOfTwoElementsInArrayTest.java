package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumProductOfTwoElementsInArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maxProduct(int[] nums, int expected) {
        var solution = new MaximumProductOfTwoElementsInArray();
        assertEquals(expected, solution.maxProduct(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {3,4,5,2}, 12),
                Arguments.of(new int[] {1,5,4,5}, 16),
                Arguments.of(new int[] {3,7}, 12),
                Arguments.of(new int[] {10,2,5,2}, 36)
        );
    }

}
