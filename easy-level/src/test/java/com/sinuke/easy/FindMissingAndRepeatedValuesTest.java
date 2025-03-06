package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FindMissingAndRepeatedValuesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findMissingAndRepeatedValues(int[][] grid, int[] expected) {
        var solution = new FindMissingAndRepeatedValues();
        assertArrayEquals(expected, solution.findMissingAndRepeatedValues(grid));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{1,3},{2,2}}, new int[] {2,4}),
                Arguments.of(new int[][] {{9,1,7},{8,9,2},{3,4,6}}, new int[] {9,5})
        );
    }

}
