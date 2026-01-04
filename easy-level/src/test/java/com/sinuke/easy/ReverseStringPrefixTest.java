package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseStringPrefixTest {

    @ParameterizedTest
    @MethodSource("testData")
    void reversePrefix(String s, int k, String expected) {
        var solution = new ReverseStringPrefix();
        assertEquals(expected, solution.reversePrefix(s, k));
        assertEquals(expected, solution.reversePrefix2(s, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("abcd", 2, "bacd"),
                Arguments.of("xyz", 3, "zyx"),
                Arguments.of("hey", 1, "hey")
        );
    }

}