package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SmallestNumberInInfiniteSetTest {

    @ParameterizedTest
    @MethodSource("testData")
    void SmallestNumberInInfiniteSet(String[] operations, Integer[] values, Integer[] expected) {
        SmallestNumberInInfiniteSet.SmallestInfiniteSet solution = null;
        Integer[] actual = new Integer[operations.length];

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "SmallestInfiniteSet" -> {
                    solution = new SmallestNumberInInfiniteSet.SmallestInfiniteSet();
                    actual[i] = null;
                }

                case "popSmallest" -> actual[i] = solution.popSmallest();
                case "addBack" -> {
                    solution.addBack(values[i]);
                    actual[i] = null;
                }

                default -> throw new IllegalArgumentException("Unknown operation " + operations[i]);
            }
        }

        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new String[] {"SmallestInfiniteSet", "addBack", "popSmallest", "popSmallest", "popSmallest", "addBack", "popSmallest", "popSmallest", "popSmallest"},
                        new Integer[] {null, 2, null, null, null, 1, null, null, null},
                        new Integer[] {null, null, 1, 2, 3, null, 1, 4, 5}
                )
        );
    }

}
