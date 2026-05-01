package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculateAmountPaidInTaxesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void calculateTax(int[][] brackets, int income, double expected) {
        assertEquals(expected, new CalculateAmountPaidInTaxes().calculateTax(brackets, income), 1e-5);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{3, 50}, {7, 10}, {12, 25}}, 10, 2.65000d),
                Arguments.of(new int[][] {{1, 0}, {4, 25}, {5, 50}}, 2, 0.25000d),
                Arguments.of(new int[][] {{2, 50}}, 0, 0.00000d)
        );
    }

}
