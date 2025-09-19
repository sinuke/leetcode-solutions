package com.sinuke.hard;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SlidingWindowMedianTest {

    @ParameterizedTest
    @MethodSource("testData")
    void medianSlidingWindow(int[] nums, int k, double[] expected) {
        var solution = new SlidingWindowMedian();
        assertArrayEquals(expected, solution.medianSlidingWindow(nums, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,3,-1,-3,5,3,6,7}, 3, new double[] {1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000}),
                Arguments.of(new int[] {1,2,3,4,2,3,1,4,2}, 3, new double[] {2.00000,3.00000,3.00000,3.00000,2.00000,3.00000,2.00000})
        );
    }

}
