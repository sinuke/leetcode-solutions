package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DesignTaskManagerTest {

    @ParameterizedTest
    @MethodSource("testData")
    void taskManagerTest(String[] operations, Object[] values, Integer[] expected) {
        DesignTaskManager.TaskManager solution = null;
        Integer[] actual = new Integer[operations.length];

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "TaskManager" -> {
                    solution = new DesignTaskManager.TaskManager((List<List<Integer>>) values[i]);
                    actual[i] = null;
                }

                case "add" -> {
                    int[] vals = (int[]) values[i];
                    solution.add(vals[0], vals[1], vals[2]);
                    actual[i] = null;
                }

                case "edit" -> {
                    int[] vals = (int[]) values[i];
                    solution.edit(vals[0], vals[1]);
                    actual[i] = null;
                }

                case "rmv" -> {
                    int[] vals = (int[]) values[i];
                    solution.rmv(vals[0]);
                    actual[i] = null;
                }

                case "execTop" -> actual[i] = solution.execTop();

                default -> throw new IllegalArgumentException("Unknown operation " + operations[i]);
            }
        }

        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new String[] {"TaskManager", "add", "edit", "execTop", "rmv", "add", "execTop"},
                        new Object[] {
                                List.of(List.of(1, 101, 10), List.of(2, 102, 20), List.of(3, 103, 15)),
                                new int[] {4, 104, 5},
                                new int[] {102, 8},
                                null,
                                new int[] {101},
                                new int[] {5, 105, 15},
                                null
                        },
                        new Integer[] {null, null, null, 3, null, null, 5}
                ),
                Arguments.of(
                        new String[] {"TaskManager","rmv","execTop"},
                        new Object[] {
                                List.of(List.of(10,26,25)),
                                new int[] {26},
                                null
                        },
                        new Integer[] {null,null,-1}
                )
        );
    }

}
