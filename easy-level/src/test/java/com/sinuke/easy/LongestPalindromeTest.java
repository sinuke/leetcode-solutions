package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestPalindromeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void longestPalindrome(String s, int expected) {
        var solution = new LongestPalindrome();
        assertEquals(expected, solution.longestPalindrome(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("abccccdd", 7),
                Arguments.of("a", 1)
        );
    }

}
