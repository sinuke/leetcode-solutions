package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DifferenceBetweenOnesAndZerosInRowAndColumnTest {

    @ParameterizedTest
    @MethodSource("testData")
    void onesMinusZeros(int[][] grid, int[][] expected) {
        var solution = new DifferenceBetweenOnesAndZerosInRowAndColumn();
        assertArrayEquals(expected, solution.onesMinusZeros(grid));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{0,1,1},{1,0,1},{0,0,1}}, new int[][] {{0,0,4},{0,0,4},{-2,-2,2}}),
                Arguments.of(new int[][] {{1,1,1},{1,1,1}}, new int[][] {{5,5,5},{5,5,5}})
        );
    }

}
