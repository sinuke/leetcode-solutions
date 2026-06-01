package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumCostOfBuyingCandiesWithDiscountTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minimumCost(int[] cost, int expected) {
        assertEquals(expected, new MinimumCostOfBuyingCandiesWithDiscount().minimumCost(cost));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, 5),
                Arguments.of(new int[]{6, 5, 7, 9, 2, 2}, 23),
                Arguments.of(new int[]{5, 5}, 10)
        );
    }

}
