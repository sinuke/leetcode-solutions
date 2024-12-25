package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ImplementStackUsingQueuesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void myStackTest(String[] operations, int[][] values, Object[] expected) {
        ImplementStackUsingQueues.MyStack myStack = null;

        Object[] actual = new Object[operations.length];

        for (int i = 0; i < operations.length; i++) {
            var operation = operations[i];

            switch (operation) {
                case "MyStack": {
                    myStack = new ImplementStackUsingQueues.MyStack();
                    actual[i] = null;
                    break;
                }

                case "push": {
                    myStack.push(values[i][0]);
                    actual[i] = null;
                    break;
                }

                case "top": {
                    actual[i] = myStack.top();
                    break;
                }

                case "pop": {
                    actual[i] = myStack.pop();
                    break;
                }

                case "empty": {
                    actual[i] = myStack.empty();
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
                        new String[] {"MyStack", "push", "push", "top", "pop", "empty"},
                        new int[][] {{}, {1}, {2}, {}, {}, {}},
                        new Object[] {null, null, null, 2, 2, false}
                )
        );
    }

}
