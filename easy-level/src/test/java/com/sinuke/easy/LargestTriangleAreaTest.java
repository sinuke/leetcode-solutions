package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LargestTriangleAreaTest {

    @ParameterizedTest
    @MethodSource("testData")
    void largestTriangleArea(int[][] points, double expected) {
        var solution = new LargestTriangleArea();
        assertEquals(expected, solution.largestTriangleArea(points));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{0,0},{0,1},{1,0},{0,2},{2,0}}, 2.00000d),
                Arguments.of(new int[][] {{1,0},{0,0},{0,1}}, 0.50000d)
        );
    }

}
