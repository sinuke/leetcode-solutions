package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckDivisibilityByDigitSumAndProductTest {

    @ParameterizedTest
    @MethodSource("testData")
    void checkDivisibility(int n, boolean expected) {
        var solution = new CheckDivisibilityByDigitSumAndProduct();
        assertEquals(expected, solution.checkDivisibility(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(99, true),
                Arguments.of(23, false)
        );
    }

}
