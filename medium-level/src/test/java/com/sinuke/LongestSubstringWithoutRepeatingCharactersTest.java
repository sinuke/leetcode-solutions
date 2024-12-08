package com.sinuke;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestSubstringWithoutRepeatingCharactersTest {

    @ParameterizedTest
    @MethodSource("testData")
    void lengthOfLongestSubstring(String input, int expected) {
        var longestSubstring = new LongestSubstringWithoutRepeatingCharacters();

        assertEquals(expected, longestSubstring.lengthOfLongestSubstring(input));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("abcabcbb", 3),
                Arguments.of("bbbbb", 1),
                Arguments.of("pwwkew", 3),
                Arguments.of("aab", 2),
                Arguments.of("dvdf", 3)
        );
    }

}