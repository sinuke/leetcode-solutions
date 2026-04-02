package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumProductOfThreeNumbersTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maximumProduct(int[] nums, int expected) {
        assertEquals(expected, new MaximumProductOfThreeNumbers().maximumProduct(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, 6),
                Arguments.of(new int[]{1, 2, 3, 4}, 24),
                Arguments.of(new int[]{-1, -2, -3}, -6)
        );
    }

}
