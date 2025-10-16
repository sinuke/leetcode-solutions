package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class NumberOfRecentCallsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void numberOfRecentCallsTest(String[] operations, Integer[] values, Integer[] expected) {
        NumberOfRecentCalls.RecentCounter solution = null;
        Integer[] actual = new Integer[operations.length];

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "RecentCounter" -> {
                    solution = new NumberOfRecentCalls.RecentCounter();
                    actual[i] = null;
                }

                case "ping" -> actual[i] = solution.ping(values[i]);
                default -> throw new IllegalArgumentException("Unknown operation: " + operations[i]);
            }
        }

        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new String[] {"RecentCounter", "ping", "ping", "ping", "ping"},
                        new Integer[] {null, 1, 100, 3001, 3002},
                        new Integer[] {null, 1, 2, 3, 3}
                )
        );
    }

}
