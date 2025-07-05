package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountIntegersWithEvenDigitSumTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countEven(int num, int expected) {
        var solution =  new CountIntegersWithEvenDigitSum();
        assertEquals(expected, solution.countEven(num));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(4, 2),
                Arguments.of(30, 14)
        );
    }

}
