package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MatrixCellsInDistanceOrderTest {

    @ParameterizedTest
    @MethodSource("testData")
    void allCellsDistOrder(int rows, int cols, int rCenter, int cCenter, int[][] expected) {
        var solution = new MatrixCellsInDistanceOrder();
        assertArrayEquals(expected, solution.allCellsDistOrder(rows, cols, rCenter, cCenter));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(1, 2, 0, 0, new int[][] {{0, 0}, {0, 1}}),
                Arguments.of(2, 2, 0, 1, new int[][] {{0, 1}, {0, 0}, {1, 1}, {1, 0}}),
                Arguments.of(2, 3, 1, 2, new int[][] {{1, 2}, {0, 2}, {1, 1}, {0, 1}, {1, 0}, {0, 0}})
        );
    }

}
