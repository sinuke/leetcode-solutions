package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DesignStackWithIncrementOperationTest {

    @ParameterizedTest
    @MethodSource("testData")
    void customStackTest(String[] operation, Object[] values, Integer[] expected) {
        DesignStackWithIncrementOperation.CustomStack solution = null;
        Integer[] actual = new Integer[operation.length];

        for (int i = 0; i < operation.length; i++) {
            switch (operation[i]) {
                case "CustomStack" -> {
                    solution = new DesignStackWithIncrementOperation.CustomStack((int) values[i]);
                    actual[i] = null;
                }

                case "push" -> {
                    solution.push((int) values[i]);
                    actual[i] = null;
                }

                case "pop" -> actual[i] = solution.pop();

                case "increment" -> {
                    int[] vals = (int[]) values[i];
                    solution.increment(vals[0], vals[1]);
                    actual[i] = null;
                }

                default -> throw new IllegalArgumentException("Unknown operation " + operation[i]);
            }
        }

        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new String[] {"CustomStack","push","push","pop","push","push","push","increment","increment","pop","pop","pop","pop"},
                        new Object[] {3, 1, 2, null, 2, 3, 4, new int[] {5, 100}, new int[] {2, 100}, null, null, null, null},
                        new Integer[] {null,null,null,2,null,null,null,null,null,103,202,201,-1}
                )
        );
    }

}