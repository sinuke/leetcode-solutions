package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Convert1DArrayInto2DArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void construct2DArray(int[] original, int m, int n, int[][] expected) {
        var solution = new Convert1DArrayInto2DArray();
        assertArrayEquals(expected, solution.construct2DArray(original, m, n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,2,3,4}, 2, 2, new int[][] {{1,2},{3,4}}),
                Arguments.of(new int[] {1,2,3}, 1, 3, new int[][] {{1,2,3}}),
                Arguments.of(new int[] {1,2}, 1, 1, new int[][] {})
        );
    }

}
