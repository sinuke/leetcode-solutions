package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckIfNumberHasEqualDigitCountAndDigitValueTest {

    @ParameterizedTest
    @MethodSource("testData")
    void digitCount(String num, boolean expected) {
        var solution = new CheckIfNumberHasEqualDigitCountAndDigitValue();
        assertEquals(expected, solution.digitCount(num));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("1210", true),
                Arguments.of("030", false)
        );
    }

}
