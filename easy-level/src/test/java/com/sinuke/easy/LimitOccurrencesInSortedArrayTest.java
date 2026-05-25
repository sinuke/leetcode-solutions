package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class LimitOccurrencesInSortedArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void limitOccurrences(int[] nums, int k, int[] expected) {
        assertArrayEquals(expected, new LimitOccurrencesInSortedArray().limitOccurrences(nums, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1, 1, 1, 2, 2, 3}, 2, new int[] {1, 1, 2, 2, 3}),
                Arguments.of(new int[] {1, 2, 3}, 1, new int[] {1, 2, 3})
        );
    }

}
