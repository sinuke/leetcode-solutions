package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DesignShuffleArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void shuffleAnArrayTest(String[] operations, Object[] values, Object[] expected) {
        DesignShuffleArray.Solution solution = null;
        Object[] actual = new Object[operations.length];

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "Solution" -> {
                    solution = new DesignShuffleArray.Solution((int[]) values[i]);
                    actual[i] = null;
                }

                // shuffle is random, so compare a sorted copy: the result must be a permutation of the input
                case "shuffle" -> {
                    int[] shuffled = solution.shuffle().clone();
                    Arrays.sort(shuffled);
                    actual[i] = shuffled;
                }
                case "reset" -> actual[i] = solution.reset();

                default -> throw new IllegalArgumentException("Unexpected value: " + operations[i]);
            }
        }

        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new String[] {"Solution", "shuffle", "reset", "shuffle"},
                        new Object[] {new int[] {1, 2, 3}, null, null, null},
                        new Object[] {null, new int[] {1, 2, 3}, new int[] {1, 2, 3}, new int[] {1, 2, 3}}
                ),
                Arguments.of(
                        new String[] {"Solution", "shuffle", "reset"},
                        new Object[] {new int[] {5}, null, null},
                        new Object[] {null, new int[] {5}, new int[] {5}}
                ),
                Arguments.of(
                        new String[] {"Solution", "shuffle", "shuffle", "reset"},
                        new Object[] {new int[] {4, 5, 6, 7}, null, null, null},
                        new Object[] {null, new int[] {4, 5, 6, 7}, new int[] {4, 5, 6, 7}, new int[] {4, 5, 6, 7}}
                )
        );
    }

}
