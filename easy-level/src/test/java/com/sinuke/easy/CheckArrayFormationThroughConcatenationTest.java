package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckArrayFormationThroughConcatenationTest {

    @ParameterizedTest
    @MethodSource("testData")
    void canFormArray(int[] arr, int[][] pieces, boolean expected) {
        assertEquals(expected, new CheckArrayFormationThroughConcatenation().canFormArray(arr, pieces));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{15, 88}, new int[][]{{88}, {15}}, true),
                Arguments.of(new int[]{49, 18, 16}, new int[][]{{16, 18, 49}}, false),
                Arguments.of(new int[]{91, 4, 64, 78}, new int[][]{{78}, {4, 64}, {91}}, true)
        );
    }

}
