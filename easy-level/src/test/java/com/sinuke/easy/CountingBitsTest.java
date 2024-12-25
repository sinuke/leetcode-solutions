package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class CountingBitsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countBits(int num, int[] expected) {
        var countingBits = new CountingBits();
        assertArrayEquals(expected, countingBits.countBits(num));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(2, new int[] {0, 1, 1}),
                Arguments.of(5, new int[] {0, 1, 1, 2, 1, 2})
        );
    }

}
