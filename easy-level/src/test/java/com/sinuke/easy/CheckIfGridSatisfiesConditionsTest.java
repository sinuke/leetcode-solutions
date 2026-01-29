package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckIfGridSatisfiesConditionsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void satisfiesConditions(int[][] grid, boolean expected) {
        var solution = new CheckIfGridSatisfiesConditions();
        assertEquals(expected, solution.satisfiesConditions(grid));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{1,0,2},{1,0,2}}, true),
                Arguments.of(new int[][] {{1,1,1},{0,0,0}}, false),
                Arguments.of(new int[][] {{1},{2},{3}}, false)
        );
    }

}
