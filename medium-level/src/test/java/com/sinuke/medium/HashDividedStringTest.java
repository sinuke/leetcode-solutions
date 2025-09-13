package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HashDividedStringTest {

    @ParameterizedTest
    @MethodSource("testData")
    void stringHash(String s, int k, String expected) {
        var solution = new HashDividedString();
        assertEquals(expected, solution.stringHash(s, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("abcd", 2, "bf"),
                Arguments.of("mxz", 3, "i")
        );
    }

}
