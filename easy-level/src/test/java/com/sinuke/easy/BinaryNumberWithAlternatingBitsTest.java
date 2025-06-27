package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryNumberWithAlternatingBitsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void hasAlternatingBits(int n, boolean expected) {
        var solution = new BinaryNumberWithAlternatingBits();
        assertEquals(expected, solution.hasAlternatingBits(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(5, true),
                Arguments.of(7, false),
                Arguments.of(11, false)
        );
    }

}
