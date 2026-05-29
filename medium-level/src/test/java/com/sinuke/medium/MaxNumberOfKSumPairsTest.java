package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxNumberOfKSumPairsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maxOperations(int[] nums, int k, int expected) {
        assertEquals(expected, new MaxNumberOfKSumPairs().maxOperations(nums, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4}, 5, 2),
                Arguments.of(new int[]{3, 1, 3, 4, 3}, 6, 1)
        );
    }

}
