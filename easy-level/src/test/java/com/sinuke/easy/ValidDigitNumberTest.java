package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidDigitNumberTest {

    @ParameterizedTest
    @MethodSource("testData")
    void validDigit(int n, int x, boolean expected) {
        assertEquals(expected, new ValidDigitNumber().validDigit(n, x));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(101, 0, true),
                Arguments.of(232, 2, false),
                Arguments.of(5, 1, false)
        );
    }

}
