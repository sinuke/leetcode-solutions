package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindTheMinimumAreaToCoverAllOnesITest {

    @ParameterizedTest
    @MethodSource("testData")
    void minimumArea(int[][] grid, int expected) {
        var solution = new FindTheMinimumAreaToCoverAllOnesI();
        assertEquals(expected, solution.minimumArea(grid));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][]{{0,1,0},{1,0,1}}, 6),
                Arguments.of(new int[][]{{1,0},{0,0}}, 1)
        );
    }

}
