package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class IntervalListIntersectionsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void intervalIntersection(int[][] firstList, int[][] secondList, int[][] expected) {
        assertArrayEquals(expected, new IntervalListIntersections().intervalIntersection(firstList, secondList));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}},
                        new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}},
                        new int[][]{{1, 2}, {5, 5}, {8, 10}, {15, 23}, {24, 24}, {25, 25}}
                ),
                Arguments.of(
                        new int[][]{{1, 3}, {5, 9}},
                        new int[][]{},
                        new int[][]{}
                )
        );
    }

}
