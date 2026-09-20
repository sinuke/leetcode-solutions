package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class CyclicallyShiftRowsAndColumnsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void cyclicShiftRowsAndColumns(int n, int[][] grid, int[] rowShift, int[] colShift, int[][] expected) {
        var solution = new CyclicallyShiftRowsAndColumns();
        assertArrayEquals(expected, solution.cyclicShift(n, grid, rowShift, colShift));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(2, new int[][] {{1, 2}, {3, 4}}, new int[] {1, 0}, new int[] {0, 1}, new int[][] {{2, 4}, {3, 1}}),
                Arguments.of(3, new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, new int[] {1, 2, 0}, new int[] {2, 2, 1}, new int[][] {{7, 8, 5}, {2, 3, 9}, {6, 4, 1}})
        );
    }

}
