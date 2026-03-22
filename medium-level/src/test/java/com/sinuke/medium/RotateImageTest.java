package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class RotateImageTest {

    @ParameterizedTest
    @MethodSource("testData")
    void rotate(int[][] matrix, int[][] expected) {
        var solution = new RotateImage();
        solution.rotate(matrix);
        assertArrayEquals(expected, matrix);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{1,2,3},{4,5,6},{7,8,9}}, new int[][] {{7,4,1},{8,5,2},{9,6,3}}),
                Arguments.of(new int[][] {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}}, new int[][] {{15,13,2,5},{14,3,4,1},{12,6,8,9},{16,7,10,11}})
        );
    }

}
