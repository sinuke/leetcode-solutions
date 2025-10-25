package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class StockPriceFluctuationTest {


    @ParameterizedTest
    @MethodSource("testData")
    void stockPriceFluctuation(String[] operations, Integer[][] values, Integer[] expected) {
        StockPriceFluctuation.StockPrice solution = null;
        Integer[] actual = new Integer[operations.length];

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "StockPrice" -> {
                    solution = new StockPriceFluctuation.StockPrice();
                    actual[i] = null;
                }

                case "update" -> {
                    solution.update(values[i][0], values[i][1]);
                    actual[i] = null;
                }

                case "current" -> actual[i] = solution.current();
                case "minimum" -> actual[i] = solution.minimum();
                case "maximum" -> actual[i] = solution.maximum();

                default -> throw new IllegalArgumentException("Unknown operation " + operations[i]);
            }
        }

        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new String[] {"StockPrice", "update", "update", "current", "maximum", "update", "maximum", "update", "minimum"},
                        new Integer[][] {{}, {1, 10}, {2, 5}, {}, {}, {1, 3}, {}, {4, 2}, {}},
                        new Integer[] {null, null, null, 5, 10, null, 5, null, 2}
                )
        );
    }

}
