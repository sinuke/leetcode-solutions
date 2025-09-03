package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpiralMatrixTest {

    @ParameterizedTest
    @MethodSource("testData")
    void spiralOrder(int[][] matrix, List<Integer> expected) {
        var solution = new SpiralMatrix();
        assertEquals(expected, solution.spiralOrder(matrix));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{1,2,3},{4,5,6},{7,8,9}}, List.of(1,2,3,6,9,8,7,4,5)),
                Arguments.of(new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}}, List.of(1,2,3,4,8,12,11,10,9,5,6,7))
        );
    }

}