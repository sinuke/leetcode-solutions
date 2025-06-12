package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ToeplitzMatrixTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isToeplitzMatrix(int[][] matrix, boolean expected) {
        var solution = new ToeplitzMatrix();
        assertEquals(expected, solution.isToeplitzMatrix(matrix));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{1,2,3,4},{5,1,2,3},{9,5,1,2}}, true),
                Arguments.of(new int[][] {{1,2},{2,2}}, false)
        );
    }

}
