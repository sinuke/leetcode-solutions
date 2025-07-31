package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BuyTwoChocolatesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void buyChoco(int[] prices, int money, int expected) {
        var solution = new BuyTwoChocolates();
        assertEquals(expected, solution.buyChoco(prices, money));
        assertEquals(expected, solution.buyChoco2(prices, money));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,2,2}, 3, 0),
                Arguments.of(new int[] {3,2,3}, 3, 3),
                Arguments.of(new int[] {98,54,6,34,66,63,52,39}, 62, 22),
                Arguments.of(new int[] {69,91,78,19,40,13}, 94, 62)
        );
    }

}
