package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindChampionITest {

    @ParameterizedTest
    @MethodSource("testData")
    void findChampion(int[][] grid, int expected) {
        var solution = new FindChampionI();
        assertEquals(expected, solution.findChampion(grid));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{0,1},{0,0}}, 0),
                Arguments.of(new int[][] {{0,0,1},{1,0,1},{0,0,0}}, 1)
        );
    }

}
