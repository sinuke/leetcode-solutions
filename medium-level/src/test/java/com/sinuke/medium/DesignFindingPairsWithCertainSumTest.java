package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DesignFindingPairsWithCertainSumTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findingPairsWithCertainSumTest(String[] operations, Object[] values, Object[] expected) {
        DesignFindingPairsWithCertainSum.FindSumPairs solution = null;
        Object[] actual = new Object[operations.length];

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "FindSumPairs" -> {
                    int[][] args = (int[][]) values[i];
                    solution = new DesignFindingPairsWithCertainSum.FindSumPairs(args[0], args[1]);
                    actual[i] = null;
                }

                case "add" -> {
                    int[] args = (int[]) values[i];
                    solution.add(args[0], args[1]);
                    actual[i] = null;
                }
                case "count" -> actual[i] = solution.count((Integer) values[i]);

                default -> throw new IllegalArgumentException("Unknown operation " + operations[i]);
            }
        }

        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new String[] {"FindSumPairs", "count", "add", "count", "count", "add", "add", "count"},
                        new Object[] {new int[][] {{1, 1, 2, 2, 2, 3}, {1, 4, 5, 2, 5, 4}}, 7, new int[] {3, 2}, 8, 4, new int[] {0, 1}, new int[] {1, 1}, 7},
                        new Object[] {null, 8, null, 2, 1, null, null, 11}
                ),
                Arguments.of(
                        new String[] {"FindSumPairs", "count", "add", "count", "count"},
                        new Object[] {new int[][] {{1}, {1}}, 2, new int[] {0, 1}, 2, 3},
                        new Object[] {null, 1, null, 0, 1}
                ),
                Arguments.of(
                        new String[] {"FindSumPairs", "count", "add", "count", "count", "add", "count", "count", "count"},
                        new Object[] {new int[][] {{1, 2}, {3, 3, 4}}, 5, new int[] {2, 1}, 5, 6, new int[] {0, 2}, 6, 7, 100},
                        new Object[] {null, 3, null, 2, 1, null, 2, 2, 0}
                )
        );
    }

}
