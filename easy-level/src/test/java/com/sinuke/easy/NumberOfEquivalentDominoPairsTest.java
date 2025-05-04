package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfEquivalentDominoPairsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void numEquivDominoPairs(int[][] dominoes, int expected) {
        var solution = new NumberOfEquivalentDominoPairs();
        assertEquals(expected, solution.numEquivDominoPairs(dominoes));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{1,2},{2,1},{3,4},{5,6}}, 1),
                Arguments.of(new int[][] {{1,2},{1,2},{1,1},{1,2},{2,2}}, 3)
        );
    }

}
