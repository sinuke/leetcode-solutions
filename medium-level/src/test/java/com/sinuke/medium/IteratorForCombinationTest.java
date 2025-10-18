package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class IteratorForCombinationTest {

    @ParameterizedTest
    @MethodSource("testData")
    void iteratorForCombination(String[] operations, String characters, int combinationLength, Object[] expected) {
        IteratorForCombination.CombinationIterator solution = null;
        Object[] actual = new Object[operations.length];

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "CombinationIterator" -> {
                    solution = new IteratorForCombination.CombinationIterator(characters, combinationLength);
                    actual[i] = null;
                }

                case "next" -> actual[i] = solution.next();
                case "hasNext" -> actual[i] = solution.hasNext();

                default -> throw new IllegalArgumentException("Unknown operation: " + operations[i]);
            }
        }

        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new String[] {"CombinationIterator", "next", "hasNext", "next", "hasNext", "next", "hasNext"},
                        "abc",
                        2,
                        new Object[] {null, "ab", true, "ac", true, "bc", false}
                )
        );
    }

}
