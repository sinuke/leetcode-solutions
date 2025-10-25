package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TimeBasedKeyValueStoreTest {

    @ParameterizedTest
    @MethodSource("testData")
    void timeBasedKeyValueStoreTest(String[] operations, Object[][] values, String[] expected) {
        TimeBasedKeyValueStore.TimeMap solution = null;
        String[] actual = new String[operations.length];

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "TimeMap" -> {
                    solution = new TimeBasedKeyValueStore.TimeMap();
                    actual[i] = null;
                }

                case "set" -> {
                    solution.set((String) values[i][0], (String) values[i][1], (int) values[i][2]);
                    actual[i] = null;
                }

                case "get" -> actual[i] = solution.get((String) values[i][0], (int) values[i][1]);

                default -> throw new IllegalArgumentException("Unknown operation: " + operations[i]);
            }
        }

        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new String[] {"TimeMap", "set", "get", "get", "set", "get", "get"},
                        new Object[][] {{}, {"foo", "bar", 1}, {"foo", 1}, {"foo", 3}, {"foo", "bar2", 4}, {"foo", 4}, {"foo", 5}},
                        new String[] {null, null, "bar", "bar", null, "bar2", "bar2"}
                )
        );
    }

}
