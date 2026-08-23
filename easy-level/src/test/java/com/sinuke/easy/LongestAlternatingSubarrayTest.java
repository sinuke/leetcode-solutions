package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestAlternatingSubarrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void alternatingSubarray(int[] nums, int expected) {
        var solution = new LongestAlternatingSubarray();
        assertEquals(expected, solution.alternatingSubarray(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{2, 3, 4, 3, 4}, 4),
                Arguments.of(new int[]{4, 5, 6}, 2)
        );
    }

}
