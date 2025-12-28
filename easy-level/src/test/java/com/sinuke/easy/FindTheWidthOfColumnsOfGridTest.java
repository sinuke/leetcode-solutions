package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FindTheWidthOfColumnsOfGridTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findColumnWidth(int[][] grid, int[] expected) {
        var solution = new FindTheWidthOfColumnsOfGrid();
        assertArrayEquals(expected, solution.findColumnWidth(grid));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{1},{22},{333}}, new int[] {3}),
                Arguments.of(new int[][] {{-15,1,3},{15,7,12},{5,6,-2}}, new int[] {3,1,2})
        );
    }

}
