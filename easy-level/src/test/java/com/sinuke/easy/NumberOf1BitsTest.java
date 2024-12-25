package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOf1BitsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void hammingWeight(int n, int expected) {
        var numberOf1Bits = new NumberOf1Bits();
        assertEquals(expected, numberOf1Bits.hammingWeight(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(11, 3),
                Arguments.of(128, 1),
                Arguments.of(2147483645, 30)
        );
    }

}