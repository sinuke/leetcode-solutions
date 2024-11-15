package com.sinuke;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PalindromeNumberTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isPalindrome(int input, boolean expected) {
        var palindrome = new PalindromeNumber();
        assertEquals(expected, palindrome.isPalindrome(input));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(121, true),
                Arguments.of(-121, false),
                Arguments.of(10, false)
        );
    }

}
