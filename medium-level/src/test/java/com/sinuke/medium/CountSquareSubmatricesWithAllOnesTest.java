package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountSquareSubmatricesWithAllOnesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countSquares(int[][] matrix, int expected) {
        var solution = new CountSquareSubmatricesWithAllOnes();
        assertEquals(expected, solution.countSquares(matrix));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{0,1,1,1},{1,1,1,1},{0,1,1,1}}, 15),
                Arguments.of(new int[][] {{1,0,1},{1,1,0},{1,1,0}}, 7)
        );
    }

}
