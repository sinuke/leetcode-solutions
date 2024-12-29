package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumBitFlipsToConvertNumberTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minBitFlips(int start, int goal, int expected) {
        var minBitFlips = new MinimumBitFlipsToConvertNumber();
        assertEquals(expected, minBitFlips.minBitFlips(start, goal));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(10, 7, 3),
                Arguments.of(3, 4, 3)
        );
    }

}