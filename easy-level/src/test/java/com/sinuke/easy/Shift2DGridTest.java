package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Shift2DGridTest {

    @ParameterizedTest
    @MethodSource("testData")
    void shiftGrid(int[][] grid, int k, List<List<Integer>> expected) {
        assertEquals(expected, new Shift2DGrid().shiftGrid(grid, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 1, List.of(List.of(9, 1, 2), List.of(3, 4, 5), List.of(6, 7, 8))),
                Arguments.of(new int[][]{{3, 8, 1, 9}, {19, 7, 2, 5}, {4, 6, 11, 10}, {12, 0, 21, 13}}, 4, List.of(List.of(12, 0, 21, 13), List.of(3, 8, 1, 9), List.of(19, 7, 2, 5), List.of(4, 6, 11, 10))),
                Arguments.of(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 9, List.of(List.of(1, 2, 3), List.of(4, 5, 6), List.of(7, 8, 9))),
                Arguments.of(new int[][]{{1},{2},{3},{4},{7},{6},{5}}, 23, List.of(List.of(6),List.of(5),List.of(1),List.of(2),List.of(3),List.of(4),List.of(7)))
        );
    }
}
