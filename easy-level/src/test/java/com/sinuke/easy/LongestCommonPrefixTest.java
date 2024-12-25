package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestCommonPrefixTest {

    @ParameterizedTest
    @MethodSource("testData")
    void longestCommonPrefix(String[] input, String expected) {
        var longestCommonPrefix = new LongestCommonPrefix();
        assertEquals(expected, longestCommonPrefix.longestCommonPrefix(input));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new String[] {"flower","flow","flight"}, "fl"),
                Arguments.of(new String[] {"dog","racecar","car"}, "")
        );
    }

}
