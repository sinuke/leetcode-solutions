package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShortestSubarrayWithOrAtLeastKITest {

    @ParameterizedTest
    @MethodSource("testData")
    void shortestSubarray(int[] nums, int k, int expected) {
        var solution = new ShortestSubarrayWithOrAtLeastKI();
        assertEquals(expected, solution.minimumSubarrayLength(nums, k));
    }

    static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, 2, 1),
                Arguments.of(new int[]{2, 1, 8}, 10, 3),
                Arguments.of(new int[]{1, 2}, 0, 1)
        );
    }

}
