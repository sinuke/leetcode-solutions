package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumMatrixSumTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maxMatrixSum(int[][] matrix, long expected) {
        var solution = new MaximumMatrixSum();
        assertEquals(expected, solution.maxMatrixSum(matrix));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{1,-1},{-1,1}}, 4L),
                Arguments.of(new int[][] {{1,2,3},{-1,-2,-3},{1,2,3}}, 16L)
        );
    }

}
