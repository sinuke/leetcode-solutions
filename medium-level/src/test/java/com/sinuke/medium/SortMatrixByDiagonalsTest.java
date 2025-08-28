package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortMatrixByDiagonalsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void sortMatrix(int[][] grid, int[][] expected) {
        var solution = new SortMatrixByDiagonals();
        assertArrayEquals(expected, solution.sortMatrix(grid));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{1,7,3},{9,8,2},{4,5,6}}, new int[][] {{8,2,3},{9,6,7},{4,5,1}}),
                Arguments.of(new int[][] {{0,1},{1,2}}, new int[][] {{2,1},{1,0}}),
                Arguments.of(new int[][] {{1}}, new int[][] {{1}})
        );
    }

}
