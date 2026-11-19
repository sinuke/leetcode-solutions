package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DesignFrequencyTrackerTest {

    @ParameterizedTest
    @MethodSource("testData")
    void frequencyTrackerTest(String[] operations, Integer[] values, Object[] expected) {
        DesignFrequencyTracker.FrequencyTracker solution = null;
        Object[] actual = new Object[operations.length];

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "FrequencyTracker" -> {
                    solution = new DesignFrequencyTracker.FrequencyTracker();
                    actual[i] = null;
                }

                case "add" -> {
                    solution.add(values[i]);
                    actual[i] = null;
                }

                case "deleteOne" -> {
                    solution.deleteOne(values[i]);
                    actual[i] = null;
                }

                case "hasFrequency" -> actual[i] = solution.hasFrequency(values[i]);

                default -> throw new IllegalArgumentException("Unknown operation " + operations[i]);
            }
        }

        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new String[] {"FrequencyTracker", "add", "add", "hasFrequency"},
                        new Integer[] {null, 3, 3, 2},
                        new Object[] {null, null, null, true}
                ),
                Arguments.of(
                        new String[] {"FrequencyTracker", "add", "deleteOne", "hasFrequency"},
                        new Integer[] {null, 1, 1, 1},
                        new Object[] {null, null, null, false}
                ),
                Arguments.of(
                        new String[] {"FrequencyTracker", "hasFrequency", "add", "hasFrequency"},
                        new Integer[] {null, 2, 3, 1},
                        new Object[] {null, false, null, true}
                )
        );
    }

}
