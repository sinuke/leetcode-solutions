package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FirstCompletelyPaintedRowOrColumnTest {

    @ParameterizedTest
    @MethodSource("testData")
    void firstCompleteIndex(int[] arr, int[][] mat, int expected) {
        var solution = new FirstCompletelyPaintedRowOrColumn();
        assertEquals(expected, solution.firstCompleteIndex(arr, mat));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,3,4,2}, new int[][] {{1,4},{2,3}}, 2),
                Arguments.of(new int[] {2,8,7,4,1,3,5,6,9}, new int[][] {{3,2,5},{1,4,6},{8,7,9}}, 3)
        );
    }

}
