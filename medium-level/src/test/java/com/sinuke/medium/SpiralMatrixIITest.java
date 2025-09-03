package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SpiralMatrixIITest {

    @ParameterizedTest
    @MethodSource("testData")
    void generateMatrix(int n, int[][] expected) {
        var solver = new SpiralMatrixII();
        assertArrayEquals(expected, solver.generateMatrix(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(3, new int[][] {{1,2,3},{8,9,4},{7,6,5}}),
                Arguments.of(1, new int[][] {{1}})
        );
    }

}
