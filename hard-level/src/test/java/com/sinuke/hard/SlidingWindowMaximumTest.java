package com.sinuke.hard;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SlidingWindowMaximumTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maxSlidingWindow(int[] nums, int k, int[] expected) {
        var solution = new  SlidingWindowMaximum();
        assertArrayEquals(expected,solution.maxSlidingWindow(nums,k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,3,-1,-3,5,3,6,7}, 3, new int[] {3,3,5,5,6,7}),
                Arguments.of(new int[] {1}, 1, new int[] {1}),
                Arguments.of(new int[] {1, -1}, 1, new int[] {1, -1}),
                Arguments.of(new int[] {9,10,9,-7,-4,-8,2,-6}, 5, new int[] {10,10,9,2}),
                Arguments.of(new int[] {-7,-8,7,5,7,1,6,0}, 4, new int[] {7,7,7,7,7}),
                Arguments.of(new int[] {1,-9,8,-6,6,4,0,5}, 4, new int[] {8,8,8,6,6})
        );
    }

}
