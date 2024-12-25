package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BestTimeBuyAndSellStockTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maxProfit(int[] input, int expected) {
        var bestTimeBuyAndSellStock = new BestTimeBuyAndSellStock();

        assertEquals(expected, bestTimeBuyAndSellStock.maxProfit(input));
        assertEquals(expected, bestTimeBuyAndSellStock.maxProfitOptimized(input));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {7, 1, 5, 3, 6, 4}, 5),
                Arguments.of(new int[] {7, 6, 4, 3, 1}, 0),
                Arguments.of(new int[] {1, 2}, 1),
                Arguments.of(new int[] {2, 1, 4}, 3),
                Arguments.of(new int[] {3, 2, 6, 5, 0, 3}, 4),
                Arguments.of(new int[] {3, 2, 6, 5, 0, 4}, 4),
                Arguments.of(new int[] {3, 2, 6, 5, 0, 5}, 5),
                Arguments.of(new int[] {2, 1, 2, 1, 0, 1, 2}, 2)
        );
    }

}
