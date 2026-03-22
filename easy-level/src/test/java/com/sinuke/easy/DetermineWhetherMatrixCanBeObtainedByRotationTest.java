package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DetermineWhetherMatrixCanBeObtainedByRotationTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findRotation(int[][] mat, int[][] target, boolean expected) {
        var solution = new DetermineWhetherMatrixCanBeObtainedByRotation();
        assertEquals(expected, solution.findRotation(mat, target));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{0,1},{1,0}}, new int[][] {{1,0},{0,1}}, true),
                Arguments.of(new int[][] {{0,1},{1,1}}, new int[][] {{1,0},{0,1}}, false),
                Arguments.of(new int[][] {{0,0,0},{0,1,0},{1,1,1}}, new int[][] {{1,1,1},{0,1,0},{0,0,0}}, true)
        );
    }

}
