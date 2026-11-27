package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DesignImplementTriePrefixTreeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void implementTriePrefixTreeTest(String[] operations, Object[] values, Object[] expected) {
        DesignImplementTriePrefixTree.Trie solution = null;
        Object[] actual = new Object[operations.length];

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "Trie" -> {
                    solution = new DesignImplementTriePrefixTree.Trie();
                    actual[i] = null;
                }

                case "insert" -> {
                    solution.insert((String) values[i]);
                    actual[i] = null;
                }

                case "search" -> actual[i] = solution.search((String) values[i]);

                case "startsWith" -> actual[i] = solution.startsWith((String) values[i]);

                default -> throw new IllegalArgumentException("Unknown operation " + operations[i]);
            }
        }

        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new String[] {"Trie", "insert", "search", "search", "startsWith", "insert", "search"},
                        new Object[] {null, "apple", "apple", "app", "app", "app", "app"},
                        new Object[] {null, null, true, false, true, null, true}
                ),
                Arguments.of(
                        new String[] {"Trie", "search", "startsWith", "insert", "startsWith", "startsWith", "search", "search"},
                        new Object[] {null, "a", "a", "abc", "abc", "abcd", "ab", "abc"},
                        new Object[] {null, false, false, null, true, false, false, true}
                ),
                Arguments.of(
                        new String[] {"Trie", "insert", "insert", "search", "startsWith", "startsWith", "search"},
                        new Object[] {null, "car", "cat", "ca", "ca", "cb", "cat"},
                        new Object[] {null, null, null, false, true, false, true}
                )
        );
    }

}
