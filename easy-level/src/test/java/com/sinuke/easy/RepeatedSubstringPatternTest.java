package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RepeatedSubstringPatternTest {

    @ParameterizedTest
    @MethodSource("testData")
    void repeatedSubstringPattern(String s, boolean expected) {
        var repeatedSubstringPattern = new RepeatedSubstringPattern();

        assertEquals(expected, repeatedSubstringPattern.repeatedSubstringPattern(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("abab", true),
                Arguments.of("aba", false),
                Arguments.of("abcabcabcabc", true)
        );
    }

}
