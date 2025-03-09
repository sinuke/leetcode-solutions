package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FlippingAnImageTest {

    @ParameterizedTest
    @MethodSource("testData")
    void flipAndInvertImage(int[][] image, int[][] expected) {
        var solution = new FlippingAnImage();
        assertArrayEquals(expected, solution.flipAndInvertImage(image));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{1,1,0},{1,0,1},{0,0,0}}, new int[][] {{1,0,0},{0,1,0},{1,1,1}}),
                Arguments.of(new int[][] {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}}, new int[][] {{1,1,0,0},{0,1,1,0},{0,0,0,1},{1,0,1,0}})
        );
    }

}
