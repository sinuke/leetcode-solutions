package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ValidPalindromeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isPalindrome(String input, boolean expected) {
        var validPalindrome = new ValidPalindrome();

        assertEquals(expected, validPalindrome.isPalindrome(input));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("A man, a plan, a canal: Panama", true),
                Arguments.of("race a car", false),
                Arguments.of(" ", true),
                Arguments.of("aa", true)
        );
    }

}
