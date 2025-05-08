package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TransposeMatrixTest {

    @ParameterizedTest
    @MethodSource("testData")
    void transpose(int[][] matrix, int[][] expected) {
        var solution = new TransposeMatrix();
        assertArrayEquals(expected, solution.transpose(matrix));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{1,2,3},{4,5,6},{7,8,9}}, new int[][] {{1,4,7},{2,5,8},{3,6,9}}),
                Arguments.of(new int[][] {{1,2,3},{4,5,6}}, new int[][] {{1,4},{2,5},{3,6}})
        );
    }

}
