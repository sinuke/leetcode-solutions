package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Search2DMatrixTest {

    @ParameterizedTest
    @MethodSource("testData")
    void searchMatrix(int[][] matrix, int target, boolean expected) {
        var solution = new Search2DMatrix();
        assertEquals(expected, solution.searchMatrix(matrix, target));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3, true),
                Arguments.of(new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 13, false)
        );
    }

}

