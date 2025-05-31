package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DistributeMoneyToMaximumChildrenTest {

    @ParameterizedTest
    @MethodSource("testData")
    void distMoney(int money, int children, int expected) {
        var solution = new DistributeMoneyToMaximumChildren();
        assertEquals(expected, solution.distMoney(money, children));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(20, 3, 1),
                Arguments.of(16, 2, 2)
        );
    }

}
