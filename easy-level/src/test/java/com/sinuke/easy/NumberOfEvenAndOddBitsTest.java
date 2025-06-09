package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class NumberOfEvenAndOddBitsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void evenOddBit(int n, int[] expected) {
        var solution = new  NumberOfEvenAndOddBits();
        assertArrayEquals(expected, solution.evenOddBit(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(50, new int[] {1, 2}),
                Arguments.of(2, new int[] {0, 1})
        );
    }

}
