package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumSwapsToSortByDigitSumTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minSwaps(int[] nums, int expected) {
        var solution = new MinimumSwapsToSortByDigitSum();
        assertEquals(expected, solution.minSwaps(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {37, 100}, 1),
                Arguments.of(new int[] {22, 14, 33, 7}, 0),
                Arguments.of(new int[] {18, 43, 34, 16}, 2)
        );
    }

}
