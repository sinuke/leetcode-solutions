package com.sinuke;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UglyNumberTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isUgly(int n, boolean expected) {
        var uglyNumber = new UglyNumber();
        assertEquals(expected, uglyNumber.isUgly(n));
        assertEquals(expected, uglyNumber.isUglyLeetcode(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(6, true),
                Arguments.of(1, true),
                Arguments.of(14, false),
                Arguments.of(-10, false),
                Arguments.of(0, false)
        );
    }

}
