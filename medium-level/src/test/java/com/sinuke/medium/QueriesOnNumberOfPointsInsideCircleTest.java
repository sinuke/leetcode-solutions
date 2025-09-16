package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class QueriesOnNumberOfPointsInsideCircleTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countPoints(int[][] points, int[][] queries, int[] expected) {
        var solution = new QueriesOnNumberOfPointsInsideCircle();
        assertArrayEquals(expected, solution.countPoints(points, queries));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][]{{1,3},{3,3},{5,3},{2,2}}, new int[][] {{2,3,1},{4,3,1},{1,1,2}}, new int[] {3,2,2}),
                Arguments.of(new int[][]{{1,1},{2,2},{3,3},{4,4},{5,5}}, new int[][] {{1,2,2},{2,2,2},{4,3,2},{4,3,3}}, new int[] {2,3,2,4})
        );
    }

}
