package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpecialPositionsInBinaryMatrixTest {

    @ParameterizedTest
    @MethodSource("testData")
    void numSpecial(int[][] mat, int expected) {
        var solution = new SpecialPositionsInBinaryMatrix();
        assertEquals(expected, solution.numSpecial(mat));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{1,0,0},{0,0,1},{1,0,0}}, 1),
                Arguments.of(new int[][] {{1,0,0},{0,1,0},{0,0,1}}, 3)
        );
    }

}
