package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeTwo2DArraysBySummingValuesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void mergeArrays(int[][] nums1, int[][] nums2, int[][] expected) {
        var solution = new MergeTwo2DArraysBySummingValues();
        assertArrayEquals(expected, solution.mergeArrays(nums1, nums2));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{1,2},{2,3},{4,5}}, new int[][] {{1,4},{3,2},{4,1}}, new int[][] {{1,6},{2,3},{3,2},{4,6}}),
                Arguments.of(new int[][] {{2,4},{3,6},{5,5}}, new int[][] {{1,3},{4,3}}, new int[][] {{1,3},{2,4},{3,6},{4,3},{5,5}})
        );
    }

}
