package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SurfaceAreaOf3DShapesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void surfaceArea(int[][] grid, int expected) {
        assertEquals(expected, new SurfaceAreaOf3DShapes().surfaceArea(grid));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 2}, {3, 4}}, 34),
                Arguments.of(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}, 32),
                Arguments.of(new int[][]{{2, 2, 2}, {2, 1, 2}, {2, 2, 2}}, 46)
        );
    }

}
