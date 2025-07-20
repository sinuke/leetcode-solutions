package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ReshapeTheMatrixTest {

    @ParameterizedTest
    @MethodSource("testData")
    void matrixReshape(int[][] mat, int r, int c, int[][] expected) {
        var solution = new ReshapeTheMatrix();
        assertArrayEquals(expected, solution.matrixReshape(mat, r, c));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{1,2}, {3,4}}, 1, 4, new int[][] {{1,2,3,4}}),
                Arguments.of(new int[][] {{1,2}, {3,4}}, 2, 4, new int[][] {{1,2}, {3,4}})
        );
    }

}
