package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class RowWithMaximumOnesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void rowAndMaximumOnes(int[][] mat, int[] expected) {
        var solution = new RowWithMaximumOnes();
        assertArrayEquals(expected, solution.rowAndMaximumOnes(mat));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{0,1},{1,0}}, new int[] {0, 1}),
                Arguments.of(new int[][] {{0,0,0},{0,1,1}}, new int[] {1, 2}),
                Arguments.of(new int[][] {{0,0},{1,1},{0,0}}, new int[] {1, 2})
        );
    }

}
