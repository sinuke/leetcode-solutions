package com.sinuke;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PowerOfTwoTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isPowerOfTwo(int n, boolean expected) {
        var powerOfTwo = new PowerOfTwo();
        assertEquals(expected, powerOfTwo.isPowerOfTwo(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(1, true),
                Arguments.of(16, true),
                Arguments.of(3, false),
                Arguments.of(131072, true),
                Arguments.of(-2147483648, false),
                Arguments.of(2147483647, false),
                Arguments.of(0, false)
        );
    }

}
