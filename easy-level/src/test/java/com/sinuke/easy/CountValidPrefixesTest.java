package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountValidPrefixesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countValidPrefixes(String s, int expected) {
        var solution = new CountValidPrefixes();
        assertEquals(expected, solution.countValidPrefixes(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("00101", 3),
                Arguments.of("101", 3)
        );
    }

}