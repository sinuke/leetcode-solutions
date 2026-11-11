package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DesignLRUCacheTest {

    @ParameterizedTest
    @MethodSource("testData")
    void lruCacheTest(String[] operations, Object[] values, Object[] expected) {
        DesignLRUCache.LRUCache solution = null;
        Object[] actual = new Object[operations.length];

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "LRUCache" -> {
                    solution = new DesignLRUCache.LRUCache((int) values[i]);
                    actual[i] = null;
                }

                case "put" -> {
                    int[] vals = (int[]) values[i];
                    solution.put(vals[0], vals[1]);
                    actual[i] = null;
                }

                case "get" -> actual[i] = solution.get((int) values[i]);

                default -> throw new IllegalArgumentException("Unknown operation " + operations[i]);
            }
        }

        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new String[] {"LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"},
                        new Object[] {2, new int[] {1, 1}, new int[] {2, 2}, 1, new int[] {3, 3}, 2, new int[] {4, 4}, 1, 3, 4},
                        new Object[] {null, null, null, 1, null, -1, null, -1, 3, 4}
                ),
                Arguments.of(
                        new String[] {"LRUCache", "put", "get", "put", "get", "get"},
                        new Object[] {1, new int[] {2, 1}, 2, new int[] {3, 2}, 2, 3},
                        new Object[] {null, null, 1, null, -1, 2}
                ),
                Arguments.of(
                        new String[] {"LRUCache", "put", "put", "get", "get"},
                        new Object[] {2, new int[] {1, 1}, new int[] {1, 10}, 1, 2},
                        new Object[] {null, null, null, 10, -1}
                )
        );
    }

}
