package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumTimeVisitingAllPointsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minTimeToVisitAllPoints(int[][] points, int expected) {
        var solution = new MinimumTimeVisitingAllPoints();
        assertEquals(expected, solution.minTimeToVisitAllPoints(points));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{1,1},{3,4},{-1,0}}, 7),
                Arguments.of(new int[][] {{3,2},{-2,2}}, 5)
        );
    }

}
