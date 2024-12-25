package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FinalPricesWithSpecialDiscountInShopTest {

    @ParameterizedTest
    @MethodSource("testData")
    void finalPrices(int[] prices, int[] expected) {
        var finalPricesWithSpecialDiscountInShop = new FinalPricesWithSpecialDiscountInShop();
        assertArrayEquals(expected, finalPricesWithSpecialDiscountInShop.finalPrices(prices));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {8, 4, 6, 2, 3}, new int[] {4, 2, 4, 2, 3}),
                Arguments.of(new int[] {1, 2, 3, 4, 5}, new int[] {1, 2, 3, 4, 5}),
                Arguments.of(new int[] {10, 1, 1, 6}, new int[] {9, 0, 1, 6})
        );
    }

}
