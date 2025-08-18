package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeIntervalsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void merge(int[][] intervals, int[][] expected) {
        var solution = new MergeIntervals();
        assertArrayEquals(expected, solution.merge(intervals));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{1,3},{2,6},{8,10},{15,18}}, new int[][] {{1,6},{8,10},{15,18}}),
                Arguments.of(new int[][] {{1,4},{4,5}}, new int[][] {{1,5}}),
                Arguments.of(new int[][] {{1,4},{2,3}}, new int[][] {{1,4}})
        );
    }

}
