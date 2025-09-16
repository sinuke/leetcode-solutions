package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DesignHashSetTest {

    @ParameterizedTest
    @MethodSource("testData")
    void myHashSetTest(String[] operations, int[][] values, Object[] expected) {
        DesignHashSet.MyHashSet myHashSet = null;
        Object[] actual = new Object[operations.length];

        for (int i = 0; i < operations.length; i++) {
            var operation = operations[i];

            switch (operation) {

                case "MyHashSet" -> {
                    myHashSet = new DesignHashSet.MyHashSet();
                    actual[i] = null;
                }

                case "add" -> {
                    myHashSet.add(values[i][0]);
                    actual[i] = null;
                }

                case "contains" -> actual[i] = myHashSet.contains(values[i][0]);

                case "remove" -> {
                    myHashSet.remove(values[i][0]);
                    actual[i] = null;
                }

                default -> throw new IllegalArgumentException("Unknown operation: " + operation);
            }
        }

        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new String[] {"MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"},
                        new int[][] {{}, {1}, {2}, {1}, {3}, {2}, {2}, {2}, {2}},
                        new Object[] {null, null, null, true, false, null, true, null, false}
                )
        );
    }

}
