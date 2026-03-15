package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TheKWeakestRowsInMatrixTest {

    @ParameterizedTest
    @MethodSource("testData")
    void kWeakestRows(int[][] mat, int k, int[] expected) {
        var solution = new TheKWeakestRowsInMatrix();
        assertArrayEquals(expected, solution.kWeakestRows(mat, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}}, 3, new int[] {2,0,3}),
                Arguments.of(new int[][] {{1,0,0,0},{1,1,1,1},{1,0,0,0},{1,0,0,0}}, 2, new int[] {0,2})
        );
    }

}
