package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfRectanglesThatCanFormTheLargestSquareTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countGoodRectangles(int[][] rectangles, int expected) {
        var solution = new NumberOfRectanglesThatCanFormTheLargestSquare();
        assertEquals(expected, solution.countGoodRectangles(rectangles));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{5,8},{3,9},{5,12},{16,5}}, 3),
                Arguments.of(new int[][] {{2,3},{3,7},{4,3},{3,7}}, 3)
        );
    }

}
