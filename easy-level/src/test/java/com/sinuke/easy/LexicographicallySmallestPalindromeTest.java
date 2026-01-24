package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LexicographicallySmallestPalindromeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void makeSmallestPalindrome(String s, String expected) {
        var solution = new LexicographicallySmallestPalindrome();
        assertEquals(expected, solution.makeSmallestPalindrome(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("egcfe", "efcfe"),
                Arguments.of("abcd", "abba"),
                Arguments.of("seven", "neven")
        );
    }

}
