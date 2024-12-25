package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PowerOfThreeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isPowerOfThree(int n, boolean expected) {
        var powerOfThree = new PowerOfThree();
        assertEquals(expected, powerOfThree.isPowerOfThree(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(27, true),
                Arguments.of(1, true),
                Arguments.of(0, false),
                Arguments.of(-1, false),
                Arguments.of(-3, false),
                Arguments.of(-9, false),
                Arguments.of(-27, false)
        );
    }

}
