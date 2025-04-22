package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculateMoneyInLeetcodeBankTest {

    @ParameterizedTest
    @MethodSource("testData")
    void totalMoney(int n, int expected) {
        var solution = new CalculateMoneyInLeetcodeBank();
        assertEquals(expected, solution.totalMoney(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(4, 10),
                Arguments.of(10, 37),
                Arguments.of(20, 96)
        );
    }

}
