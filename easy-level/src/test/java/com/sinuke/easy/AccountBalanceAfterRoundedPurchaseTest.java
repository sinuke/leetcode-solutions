package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountBalanceAfterRoundedPurchaseTest {

    @ParameterizedTest
    @MethodSource("testData")
    void accountBalanceAfterPurchase(int purchaseAmount, int expected) {
        var solution = new AccountBalanceAfterRoundedPurchase();
        assertEquals(expected, solution.accountBalanceAfterPurchase(purchaseAmount));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(9, 90),
                Arguments.of(15, 80),
                Arguments.of(10, 90)
        );
    }

}
