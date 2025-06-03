package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CellsWithOddValuesInMatrixTest {

    @ParameterizedTest
    @MethodSource("testData")
    void oddCells(int m, int n, int[][] indices, int expected) {
        var solution = new CellsWithOddValuesInMatrix();
        assertEquals(expected, solution.oddCells(m, n, indices));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(2, 3, new int[][] {{0,1},{1,1}}, 6),
                Arguments.of(2, 2, new int[][] {{1,1},{0,0}}, 0)
        );
    }

}
