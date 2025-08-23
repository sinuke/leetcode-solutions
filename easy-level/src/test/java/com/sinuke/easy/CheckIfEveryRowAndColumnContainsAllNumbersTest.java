package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckIfEveryRowAndColumnContainsAllNumbersTest {

    @ParameterizedTest
    @MethodSource("testData")
    void checkValid(int[][] matrix, boolean expected) {
        var solution = new CheckIfEveryRowAndColumnContainsAllNumbers();
        assertEquals(expected, solution.checkValid(matrix));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{1,2,3},{3,1,2},{2,3,1}}, true),
                Arguments.of(new int[][] {{1,1,1},{1,2,3},{1,2,3}}, false)
        );
    }

}
