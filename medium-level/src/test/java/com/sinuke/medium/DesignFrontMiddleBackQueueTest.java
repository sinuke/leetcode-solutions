package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DesignFrontMiddleBackQueueTest {

    @ParameterizedTest
    @MethodSource("testData")
    void DesignFrontMiddleBackQueueTest(String[] operations, Integer[] values, Integer[] expected) {
        DesignFrontMiddleBackQueue.FrontMiddleBackQueue solution = null;
        Integer[] actual = new Integer[operations.length];

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "FrontMiddleBackQueue" -> {
                    solution = new DesignFrontMiddleBackQueue.FrontMiddleBackQueue();
                    actual[i] = null;
                }

                case "pushFront" -> {
                    solution.pushFront(values[i]);
                    actual[i] = null;
                }

                case "pushMiddle" -> {
                    solution.pushMiddle(values[i]);
                    actual[i] = null;
                }

                case "pushBack" -> {
                    solution.pushBack(values[i]);
                    actual[i] = null;
                }

                case "popFront" -> actual[i] = solution.popFront();
                case "popMiddle" -> actual[i] = solution.popMiddle();
                case "popBack" -> actual[i] = solution.popBack();

                default -> throw new IllegalArgumentException("Unsupported operation: " + operations[i]);
            }
        }

        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new String[] {"FrontMiddleBackQueue", "pushFront", "pushBack", "pushMiddle", "pushMiddle", "popFront", "popMiddle", "popMiddle", "popBack", "popFront"},
                        new Integer[] {null, 1, 2, 3, 4, null, null, null, null, null},
                        new Integer[] {null, null, null, null, null, 1, 3, 4, 2, -1}
                )
        );
    }

}
