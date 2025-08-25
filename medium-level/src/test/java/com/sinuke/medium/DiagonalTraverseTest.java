package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DiagonalTraverseTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findDiagonalOrder(int[][] mat, int[] expected) {
        var solution = new DiagonalTraverse();
        assertArrayEquals(expected, solution.findDiagonalOrder(mat));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{1,2,3},{4,5,6},{7,8,9}}, new int[] {1,2,4,7,5,3,6,8,9}),
                Arguments.of(new int[][] {{1,2},{3,4}}, new int[] {1,2,3,4}),
                Arguments.of(new int[][] {{6,9,7}}, new int[] {6,9,7})
        );
    }

}
