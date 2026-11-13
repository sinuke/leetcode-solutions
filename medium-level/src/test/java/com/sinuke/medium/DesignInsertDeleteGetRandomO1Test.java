package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DesignInsertDeleteGetRandomO1Test {

    @ParameterizedTest
    @MethodSource("testData")
    void insertDeleteGetRandomO1Test(String[] operations, Integer[] values, Object[] expected) {
        DesignInsertDeleteGetRandomO1.RandomizedSet solution = null;
        Object[] actual = new Object[operations.length];
        Set<Integer> elements = new HashSet<>();

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "RandomizedSet" -> {
                    solution = new DesignInsertDeleteGetRandomO1.RandomizedSet();
                    actual[i] = null;
                }

                case "insert" -> {
                    actual[i] = solution.insert(values[i]);
                    elements.add(values[i]);
                }

                case "remove" -> {
                    actual[i] = solution.remove(values[i]);
                    elements.remove(values[i]);
                }

                // getRandom is random: verify it returns an element of the set instead of a fixed value
                case "getRandom" -> {
                    int random = solution.getRandom();
                    assertTrue(elements.contains(random), "getRandom returned " + random + " which is not in " + elements);
                    actual[i] = null;
                }

                default -> throw new IllegalArgumentException("Unknown operation " + operations[i]);
            }
        }

        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new String[] {"RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"},
                        new Integer[] {null, 1, 2, 2, null, 1, 2, null},
                        new Object[] {null, true, false, true, null, true, false, null}
                ),
                Arguments.of(
                        new String[] {"RandomizedSet", "remove", "insert", "insert", "remove", "remove", "insert", "getRandom"},
                        new Integer[] {null, 42, 42, -7, -7, 42, -7, null},
                        new Object[] {null, false, true, true, true, true, true, null}
                ),
                Arguments.of(
                        new String[] {"RandomizedSet", "insert", "insert", "remove", "getRandom"},
                        new Integer[] {null, 5, 3, 6, null},
                        new Object[] {null, true, true, false, null}
                )
        );
    }

}
