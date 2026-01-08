package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeleteGreatestValueInEachRowTest {

    @ParameterizedTest
    @MethodSource("testData")
    void deleteGreatestValue(int[][] grid, int expected) {
        var solution = new DeleteGreatestValueInEachRow();
        assertEquals(expected, solution.deleteGreatestValue(grid));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{1,2,4},{3,3,1}}, 8),
                Arguments.of(new int[][] {{10}}, 10)
        );
    }

}
