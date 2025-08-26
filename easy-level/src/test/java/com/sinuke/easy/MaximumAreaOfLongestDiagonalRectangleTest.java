package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumAreaOfLongestDiagonalRectangleTest {

    @ParameterizedTest
    @MethodSource("testData")
    void areaOfMaxDiagonal(int[][] dimensions, int expected) {
        var solution = new MaximumAreaOfLongestDiagonalRectangle();
        assertEquals(expected, solution.areaOfMaxDiagonal(dimensions));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{9,3},{8,6}}, 48),
                Arguments.of(new int[][] {{3,4},{4,3}}, 12),
                Arguments.of(new int[][] {{2,6},{5,1},{3,10},{8,4}}, 30),
                Arguments.of(new int[][] {{6,5},{8,6},{2,10},{8,1},{9,2},{3,5},{3,5}}, 20)
        );
    }

}
