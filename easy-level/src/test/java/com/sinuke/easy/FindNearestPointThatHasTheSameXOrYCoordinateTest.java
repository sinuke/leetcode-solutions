package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindNearestPointThatHasTheSameXOrYCoordinateTest {

    @ParameterizedTest
    @MethodSource("testData")
    void nearestValidPoint(int x, int y, int[][] points, int expected) {
        var solution = new FindNearestPointThatHasTheSameXOrYCoordinate();
        assertEquals(expected, solution.nearestValidPoint(x, y, points));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(3, 4, new int[][] {{1,2},{3,1},{2,4},{2,3},{4,4}}, 2),
                Arguments.of(3, 4, new int[][] {{3,4}}, 0),
                Arguments.of(3, 4, new int[][] {{2,3}}, -1)
        );
    }

}
