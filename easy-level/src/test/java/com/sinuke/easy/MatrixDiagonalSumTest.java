package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MatrixDiagonalSumTest {

    @ParameterizedTest
    @MethodSource("testData")
    void diagonalSum(int[][] mat, int expected) {
        var solution = new MatrixDiagonalSum();
        assertEquals(expected, solution.diagonalSum(mat));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{1,2,3}, {4,5,6}, {7,8,9}}, 25),
                Arguments.of(new int[][] {{1,1,1,1}, {1,1,1,1}, {1,1,1,1}, {1,1,1,1}}, 8),
                Arguments.of(new int[][] {{5}}, 5)
        );
    }

}
