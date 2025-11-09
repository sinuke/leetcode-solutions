package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FlipSquareSubmatrixVerticallyTest {

    @ParameterizedTest
    @MethodSource("testData")
    void reverseSubmatrix(int[][] grid, int x, int y, int k, int[][] expected) {
        var solution = new FlipSquareSubmatrixVertically();
        assertArrayEquals(expected, solution.reverseSubmatrix(grid, x, y, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}}, 1, 0, 3, new int[][] {{1,2,3,4},{13,14,15,8},{9,10,11,12},{5,6,7,16}}),
                Arguments.of(new int[][] {{3,4,2,3},{2,3,4,2}}, 0, 2, 2, new int[][] {{3,4,4,2},{2,3,2,3}})
        );
    }

}
