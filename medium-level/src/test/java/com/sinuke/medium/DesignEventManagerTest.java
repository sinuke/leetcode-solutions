package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DesignEventManagerTest {

    @ParameterizedTest
    @MethodSource("testData")
    void eventManagerTest(String[] operations, Object[] values, Object[] expected) {
        DesignEventManager.EventManager solution = null;
        Object[] actual = new Object[operations.length];

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "EventManager" -> {
                    solution = new DesignEventManager.EventManager((int[][]) values[i]);
                    actual[i] = null;
                }

                case "updatePriority" -> {
                    int[] vals = (int[]) values[i];
                    solution.updatePriority(vals[0], vals[1]);
                    actual[i] = null;
                }

                case "pollHighest" -> actual[i] = solution.pollHighest();

                default -> throw new IllegalArgumentException("Unknown operation " + operations[i]);
            }
        }

        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new String[] {"EventManager", "pollHighest", "updatePriority", "pollHighest", "pollHighest"},
                        new Object[] {new int[][] {{5, 7}, {2, 7}, {9, 4}}, null, new int[] {9, 7}, null, null},
                        new Object[] {null, 2, null, 5, 9}
                ),
                Arguments.of(
                        new String[] {"EventManager", "pollHighest", "pollHighest", "pollHighest"},
                        new Object[] {new int[][] {{4, 1}, {7, 2}}, null, null, null},
                        new Object[] {null, 7, 4, -1}
                ),
                Arguments.of(
                        new String[] {"EventManager", "updatePriority", "pollHighest", "pollHighest", "pollHighest"},
                        new Object[] {new int[][] {{10, 3}, {4, 8}}, new int[] {4, 2}, null, null, null},
                        new Object[] {null, null, 10, 4, -1}
                )
        );
    }

}
