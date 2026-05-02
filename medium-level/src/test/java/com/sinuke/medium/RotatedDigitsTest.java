package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RotatedDigitsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void rotatedDigits(int n, int expected) {
        var solution = new RotatedDigits();
        assertEquals(expected, solution.rotatedDigits(n));
        assertEquals(expected, solution.rotatedDigits2(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(10, 4),
                Arguments.of(1, 0),
                Arguments.of(2, 1)
        );
    }

}
