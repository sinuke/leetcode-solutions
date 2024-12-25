package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PowerOfFourTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isPowerOfFour(int n, boolean expected) {
        var powerOfFour = new PowerOfFour();
        assertEquals(expected, powerOfFour.isPowerOfFour(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(16, true),
                Arguments.of(5, false),
                Arguments.of(1, true),
                Arguments.of(8, false)
        );
    }

}
