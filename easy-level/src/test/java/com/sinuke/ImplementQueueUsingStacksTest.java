package com.sinuke;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ImplementQueueUsingStacksTest {

    @ParameterizedTest
    @MethodSource("testData")
    void myQueueTest(String[] operations, int[][] values, Object[] expected) {
        ImplementQueueUsingStacks.MyQueue myQueue = null;

        Object[] actual = new Object[operations.length];

        for (int i = 0; i < operations.length; i++) {
            var operation = operations[i];

            switch (operation) {
                case "MyQueue": {
                    myQueue = new ImplementQueueUsingStacks.MyQueue();
                    actual[i] = null;
                    break;
                }

                case "push": {
                    myQueue.push(values[i][0]);
                    actual[i] = null;
                    break;
                }

                case "pop": {
                    actual[i] = myQueue.pop();
                    break;
                }

                case "peek": {
                    actual[i] = myQueue.peek();
                    break;
                }

                case "empty": {
                    actual[i] = myQueue.empty();
                    break;
                }

                default: throw new IllegalArgumentException("Unknown operation: " + operation);
            }
        }

        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new String[] {"MyQueue", "push", "push", "peek", "pop", "empty"},
                        new int[][] {{}, {1}, {2}, {}, {}, {}},
                        new Object[] {null, null, null, 1, 1, false}
                )
        );
    }

}
