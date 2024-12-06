package com.sinuke;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseBitsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void reverseBits(int n, int expected) {
        var reverseBits = new ReverseBits();
        assertEquals(expected, reverseBits.reverseBits(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(43261596, 964176192), // 00000010100101000001111010011100 -> 00111001011110000010100101000000
                Arguments.of(-3, -1073741825)              // 11111111111111111111111111111101 -> 10111111111111111111111111111111
        );
    }

}
