package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DesignNeighborSumServiceTest {

    @ParameterizedTest
    @MethodSource("testData")
    void neighborSumTest(String[] operations, Object[] values, Integer[] expected) {
        DesignNeighborSumService.NeighborSum neighborSum = null;
        Integer[] actual = new Integer[operations.length];

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "NeighborSum" -> {
                    neighborSum = new DesignNeighborSumService.NeighborSum((int[][]) values[i]);
                    actual[i] = null;
                }

                case "adjacentSum" -> actual[i] = neighborSum.adjacentSum((int) values[i]);

                case "diagonalSum" -> actual[i] = neighborSum.diagonalSum((int) values[i]);

                default -> throw new IllegalArgumentException("Unknown operation: " + operations[i]);
            }
        }

        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new String[] {"NeighborSum", "adjacentSum", "adjacentSum", "diagonalSum", "diagonalSum"},
                        new Object[] {new int[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}}, 1, 4, 4, 8},
                        new Integer[] {null, 6, 16, 16, 4}
                ),
                Arguments.of(
                        new String[] {"NeighborSum", "adjacentSum", "diagonalSum"},
                        new Object[] {new int[][]{{1, 2, 0, 3}, {4, 7, 15, 6}, {8, 9, 10, 11}, {12, 13, 14, 5}}, 15, 9},
                        new Integer[] {null, 23, 45}
                )
        );
    }

}