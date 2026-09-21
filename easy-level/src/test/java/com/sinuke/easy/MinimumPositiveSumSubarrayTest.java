package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumPositiveSumSubarrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minimumSumSubarray(List<Integer> nums, int l, int r, int expected) {
        var solution = new MinimumPositiveSumSubarray();
        assertEquals(expected, solution.minimumSumSubarray(nums, l, r));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(List.of(3, -2, 1, 4), 2, 3, 1),
                Arguments.of(List.of(-2, 2, -3, 1), 2, 3, -1),
                Arguments.of(List.of(1, 2, 3, 4), 2, 4, 3)
        );
    }

}
