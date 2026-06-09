package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidPalindromeIITest {

    @ParameterizedTest
    @MethodSource("testData")
    void validPalindrome(String s, boolean expected) {
        assertEquals(expected, new ValidPalindromeII().validPalindrome(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("aba", true),
                Arguments.of("abca", true),
                Arguments.of("abc", false)
        );
    }

}
