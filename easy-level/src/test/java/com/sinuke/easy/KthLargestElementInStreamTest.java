package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class KthLargestElementInStreamTest {

    @ParameterizedTest
    @MethodSource("testData")
    void kthLargestTest(String[] operations, int[][] values, Integer[] expected) {
        KthLargestElementInStream.KthLargest kthLargest = null;

        Integer[] actual = new Integer[operations.length];

        for (int i = 0; i < operations.length; i++) {
            var operation = operations[i];

            switch (operation) {
                case "KthLargest" -> {
                    kthLargest = new KthLargestElementInStream.KthLargest(values[i][0], Arrays.copyOfRange(values[i], 1, values[i].length));
                    actual[i] = null;
                }

                case "add" -> actual[i] = kthLargest.add(values[i][0]);

                default -> throw new IllegalArgumentException("Unknown operation: " + operation);
            }
        }

        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new String[] {"KthLargest", "add", "add", "add", "add", "add"},
                        new int[][] {{3, 4, 5, 8, 2}, {3}, {5}, {10}, {9}, {4}},
                        new Integer[] {null, 4, 5, 5, 8, 8}
                ),
                Arguments.of(
                        new String[] {"KthLargest", "add", "add", "add", "add"},
                        new int[][] {{4, 7, 7, 7, 7, 8, 3}, {2}, {10}, {9}, {9}},
                        new Integer[] {null, 7, 7, 7, 8}
                )
        );
    }

}
