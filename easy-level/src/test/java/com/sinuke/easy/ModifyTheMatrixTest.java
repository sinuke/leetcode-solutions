package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ModifyTheMatrixTest {

    @ParameterizedTest
    @MethodSource("testData")
    void modifiedMatrix(int[][] matrix, int[][] expected) {
        var solution = new ModifyTheMatrix();
        assertArrayEquals(expected, solution.modifiedMatrix(matrix));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{1,2,-1},{4,-1,6},{7,8,9}}, new int[][] {{1,2,9},{4,8,6},{7,8,9}}),
                Arguments.of(new int[][] {{3,-1},{5,2}}, new int[][] {{3,2},{5,2}})
        );
    }

}
