package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckAsciiPalindromicTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isAsciiPalindromic(String s, boolean expected) {
        var checker = new CheckAsciiPalindromic();
        assertEquals(expected, checker.isPalindromic(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("ff", true),
                Arguments.of("leet", false)
        );
    }

}
