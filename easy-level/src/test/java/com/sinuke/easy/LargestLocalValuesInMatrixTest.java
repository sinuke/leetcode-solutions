package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class LargestLocalValuesInMatrixTest {

    @ParameterizedTest
    @MethodSource("testData")
    void largestLocal(int[][] grid, int[][] expected) {
        var solution = new LargestLocalValuesInMatrix();
        assertArrayEquals(expected, solution.largestLocal(grid));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{9,9,8,1},{5,6,2,6},{8,2,6,4},{6,2,2,2}}, new int[][] {{9,9},{8,6}}),
                Arguments.of(new int[][] {{1,1,1,1,1},{1,1,1,1,1},{1,1,2,1,1},{1,1,1,1,1},{1,1,1,1,1}}, new int[][] {{2,2,2},{2,2,2},{2,2,2}})
        );
    }

}
