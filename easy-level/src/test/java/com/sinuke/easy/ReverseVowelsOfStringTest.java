package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseVowelsOfStringTest {

    @ParameterizedTest
    @MethodSource("testData")
    void reverseVowels(String s, String expected) {
        var reverseVowels = new ReverseVowelsOfString();
        assertEquals(expected, reverseVowels.reverseVowels(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("IceCreAm", "AceCreIm"),
                Arguments.of("leetcode", "leotcede"),
                Arguments.of("a.", "a."),
                Arguments.of(".a", ".a"),
                Arguments.of("ea", "ae"),
                Arguments.of("a a", "a a")
        );
    }

}
