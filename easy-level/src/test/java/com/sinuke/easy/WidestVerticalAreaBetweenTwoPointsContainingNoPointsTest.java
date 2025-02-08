package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WidestVerticalAreaBetweenTwoPointsContainingNoPointsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maxWidthOfVerticalArea(int[][] points, int expected) {
        var solution = new WidestVerticalAreaBetweenTwoPointsContainingNoPoints();
        assertEquals(expected, solution.maxWidthOfVerticalArea(points));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{8,7},{9,9},{7,4},{9,7}}, 1),
                Arguments.of(new int[][] {{3,1},{9,0},{1,0},{1,4},{5,3},{8,8}}, 3)
        );
    }

}
