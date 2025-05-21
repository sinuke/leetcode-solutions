package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SetMatrixZeroesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void setZeroes(int[][] matrix, int[][] expected) {
        var solution = new SetMatrixZeroes();
        solution.setZeroes(matrix);
        assertArrayEquals(expected, matrix);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{1,1,1},{1,0,1},{1,1,1}}, new int[][] {{1,0,1},{0,0,0},{1,0,1}}),
                Arguments.of(new int[][] {{0,1,2,0},{3,4,5,2},{1,3,1,5}}, new int[][] {{0,0,0,0},{0,4,5,0},{0,3,1,0}})
        );
    }

}
