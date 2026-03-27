package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MatrixSimilarityAfterCyclicShiftsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void areSimilar(int[][] mat, int k, boolean expected) {
        var solution = new MatrixSimilarityAfterCyclicShifts();
        assertEquals(expected, solution.areSimilar(mat, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][]{{1,2,3}, {4,5,6}, {7,8,9}}, 4, false),
                Arguments.of(new int[][]{{1, 2, 1, 2}, {5, 5, 5, 5}, {6, 7, 6, 7}}, 2, true),
                Arguments.of(new int[][]{{2, 2}, {2, 2}}, 3, true)
        );
    }

}
