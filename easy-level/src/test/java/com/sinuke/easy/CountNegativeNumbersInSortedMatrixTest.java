package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountNegativeNumbersInSortedMatrixTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countNegatives(int[][] grid, int expected) {
        var solution = new CountNegativeNumbersInSortedMatrix();
        assertEquals(expected, solution.countNegatives(grid));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}}, 8),
                Arguments.of(new int[][] {{3,2},{1,0}}, 0)
        );
    }

}
