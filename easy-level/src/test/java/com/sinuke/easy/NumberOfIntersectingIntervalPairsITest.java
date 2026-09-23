package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfIntersectingIntervalPairsITest {

    @ParameterizedTest
    @MethodSource("testData")
    void countIntersectingIntervals(int[][] intervals, int expected) {
        var solution = new NumberOfIntersectingIntervalPairsI();
        assertEquals(expected, solution.countIntersectingIntervals(intervals));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{1, 2}, {2, 3}, {3, 4}}, 2),
                Arguments.of(new int[][] {{1, 5}, {2, 4}, {3, 6}}, 3),
                Arguments.of(new int[][] {{1, 2}, {3, 4}, {5, 6}}, 0)
        );
    }

}
