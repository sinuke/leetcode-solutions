package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SubstringMatchingPatternTest {

    @ParameterizedTest
    @MethodSource("testData")
    void hasMatch(String s, String p, boolean expected) {
        var substringMatchingPattern = new SubstringMatchingPattern();
        assertEquals(expected, substringMatchingPattern.hasMatch(s, p));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("leetcode", "ee*e", true),
                Arguments.of("car", "c*v", false),
                Arguments.of("luck", "u*", true)
        );
    }

}
