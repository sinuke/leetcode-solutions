package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DesignProductOfLastKNumbersTest {

    @ParameterizedTest
    @MethodSource("testData")
    void productOfLastKNumbersTest(String[] operations, Integer[] values, Object[] expected) {
        DesignProductOfLastKNumbers.ProductOfNumbers solution = null;
        Object[] actual = new Object[operations.length];

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "ProductOfNumbers" -> {
                    solution = new DesignProductOfLastKNumbers.ProductOfNumbers();
                    actual[i] = null;
                }

                case "add" -> {
                    solution.add(values[i]);
                    actual[i] = null;
                }
                case "getProduct" -> actual[i] = solution.getProduct(values[i]);

                default -> throw new IllegalArgumentException("Unexpected value: " + operations[i]);
            }
        }

        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new String[] {"ProductOfNumbers", "add", "add", "add", "add", "add", "getProduct", "getProduct", "getProduct", "add", "getProduct"},
                        new Integer[] {null, 3, 0, 2, 5, 4, 2, 3, 4, 8, 2},
                        new Object[] {null, null, null, null, null, null, 20, 40, 0, null, 32}
                ),
                Arguments.of(
                        new String[] {"ProductOfNumbers","add","getProduct","getProduct","getProduct","add","add","add"},
                        new Integer[] {null, 1, 1, 1, 1, 7, 6, 7},
                        new Object[] {null, null, 1, 1, 1, null, null, null}
                )
        );
    }

}
