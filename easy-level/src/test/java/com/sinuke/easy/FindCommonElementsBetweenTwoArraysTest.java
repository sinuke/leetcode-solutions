package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FindCommonElementsBetweenTwoArraysTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findIntersectionValues(int[] nums1, int[] nums2, int[] expected) {
        var solution = new FindCommonElementsBetweenTwoArrays();
        assertArrayEquals(expected, solution.findIntersectionValues(nums1, nums2));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {2,3,2}, new int[] {1,2}, new int[] {2,1}),
                Arguments.of(new int[] {4,3,2,3,1}, new int[] {2,2,5,2,3,6}, new int[] {3,4}),
                Arguments.of(new int[] {3,4,2,3}, new int[] {1,5}, new int[] {0,0})
        );
    }

}
