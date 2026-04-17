package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FloodFillTest {

    @ParameterizedTest
    @MethodSource("testData")
    void floodFill(int[][] image, int sr, int sc, int color, int[][] expected) {
        assertArrayEquals(expected, new FloodFill().floodFill(image, sr, sc, color));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{1,1,1},{1,1,0},{1,0,1}}, 1, 1, 2, new int[][] {{2,2,2},{2,2,0},{2,0,1}}),
                Arguments.of(new int[][] {{0,0,0},{0,0,0}}, 0, 0, 0, new int[][] {{0,0,0},{0,0,0}})
        );
    }

}
