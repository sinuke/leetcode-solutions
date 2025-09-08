package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class PeekingIteratorSolutionTest {

    @ParameterizedTest
    @MethodSource("testData")
    void PeekingIteratorSolutionTest(String[] operations, Iterator<Integer> iterator, Object[] expected) {
        PeekingIteratorSolution.PeekingIterator solution = null;
        Object[] actual = new Object[operations.length];

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "PeekingIterator": {
                    solution = new PeekingIteratorSolution.PeekingIterator(iterator);
                    actual[i] = null;
                    break;
                }

                case "hasNext": {
                    actual[i] = solution.hasNext();
                    break;
                }

                case "next": {
                    actual[i] = solution.next();
                    break;
                }

                case "peek": {
                    actual[i] = solution.peek();
                    break;
                }

                default: throw new IllegalArgumentException("Unknown operation: " + operations[i]);
            }
        }

        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new String[] {"PeekingIterator", "next", "peek", "next", "next", "hasNext"},
                        List.of(1, 2, 3).iterator(),
                        new Object[] {null, 1, 2, 2, 3, false}
                )
        );
    }

}