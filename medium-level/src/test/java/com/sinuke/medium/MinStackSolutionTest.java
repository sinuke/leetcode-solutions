package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MinStackSolutionTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minStackTest(String[] operations, Integer[] values, Object[] expected) {
        MinStackSolution.MinStack solution = null;
        Object[] actual = new Object[operations.length];

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "MinStack" -> {
                    solution = new MinStackSolution.MinStack();
                    actual[i] = null;
                }

                case "push" -> {
                    solution.push(values[i]);
                    actual[i] = null;
                }

                case "pop" -> {
                    solution.pop();
                    actual[i] = null;
                }

                case "top" -> actual[i] = solution.top();

                case "getMin" -> actual[i] = solution.getMin();

                default -> throw new IllegalArgumentException("Unknown operation: " + operations[i]);
            }
        }

        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new String[] {"MinStack","push","push","push","getMin","pop","top","getMin"},
                        new Integer[] {null, -2, 0, -3, null, null, null, null},
                        new Object[] {null,null,null,null,-3,null,0,-2}
                ),
                Arguments.of(
                        new String[] {"MinStack","push","push","push","getMin","pop","getMin","pop","getMin","pop","push","push","push","getMin","pop","top","getMin","pop","getMin","pop"},
                        new Integer[] {null,0,1,0,null,null,null,null,null,null,-2,-1,-2,null,null,null,null,null,null,null},
                        new Object[] {null,null,null,null,0,null,0,null,0,null,null,null,null,-2,null,-1,-2,null,-2,null}
                )
        );
    }

}