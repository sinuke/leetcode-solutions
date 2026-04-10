package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProjectionAreaOf3DShapesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void projectionArea(int[][] grid, int expected) {
        assertEquals(expected, new ProjectionAreaOf3DShapes().projectionArea(grid));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 2}, {3, 4}}, 17),
                Arguments.of(new int[][]{{2}}, 5),
                Arguments.of(new int[][]{{1, 0}, {0, 2}}, 8)
        );
    }

}
