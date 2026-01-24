package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckIfMatrixIsXMatrixTest {

    @ParameterizedTest
    @MethodSource("testData")
    void checkXMatrix(int[][] grid, boolean expected) {
        var solution = new CheckIfMatrixIsXMatrix();
        assertEquals(expected, solution.checkXMatrix(grid));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{2,0,0,1},{0,3,1,0},{0,5,2,0},{4,0,0,2}}, true),
                Arguments.of(new int[][] {{5,7,0},{0,3,1},{0,5,0}}, false)
        );
    }

}
