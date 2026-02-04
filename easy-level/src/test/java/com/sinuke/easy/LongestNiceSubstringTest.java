package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestNiceSubstringTest {

    @ParameterizedTest
    @MethodSource("testData")
    void longestNiceSubstring(String s, String expected) {
        var solution = new LongestNiceSubstring();
        assertEquals(expected, solution.longestNiceSubstring(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("YazaAay", "aAa"),
                Arguments.of("Bb", "Bb"),
                Arguments.of("c", "")
        );
    }

}
