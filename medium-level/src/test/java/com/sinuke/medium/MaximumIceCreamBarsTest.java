package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumIceCreamBarsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maxIceCream(int[] costs, int coins, int expected) {
        assertEquals(expected, new MaximumIceCreamBars().maxIceCream(costs, coins));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1, 3, 2, 4, 1}, 7, 4),
                Arguments.of(new int[] {10, 6, 8, 7, 7, 8}, 5, 0),
                Arguments.of(new int[] {1, 6, 3, 1, 2, 5}, 20, 6)
        );
    }

}
