package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DesignHashMapTest {

    @ParameterizedTest
    @MethodSource("testData")
    void myHashMapTest(String[] operations, int[][] values, Integer[] expected) {
        DesignHashMap.MyHashMap myHashMap = null;

        Integer[] actual = new Integer[operations.length];
        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "MyHashMap" -> {
                    myHashMap = new DesignHashMap.MyHashMap();
                    actual[i] = null;
                }

                case "put" -> {
                    myHashMap.put(values[i][0], values[i][1]);
                    actual[i] = null;
                }

                case "get" -> actual[i] = myHashMap.get(values[i][0]);

                case "remove" -> {
                    myHashMap.remove(values[i][0]);
                    actual[i] = null;
                }

                default -> throw new IllegalArgumentException("Unknown operation: " + operations[i]);
            }
        }

        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new String[] {"MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"},
                        new int[][] {{}, {1, 1}, {2, 2}, {1}, {3}, {2, 1}, {2}, {2}, {2}},
                        new Integer[] {null, null, null, 1, -1, null, 1, null, -1}
                )
        );
    }

}