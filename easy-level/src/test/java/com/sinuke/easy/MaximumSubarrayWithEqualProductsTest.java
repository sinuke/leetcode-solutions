package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumSubarrayWithEqualProductsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maxLength(int[] nums, int expected) {
        var solution = new MaximumSubarrayWithEqualProducts();
        assertEquals(expected, solution.maxLength(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 1, 2, 1, 1, 1}, 5),
                Arguments.of(new int[]{2, 3, 4, 5, 6}, 3),
                Arguments.of(new int[]{1, 2, 3, 1, 4, 5, 1}, 5)
        );
    }

}
