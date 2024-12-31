package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReversePrefixOfWordTest {

    @ParameterizedTest
    @MethodSource("testData")
    void reversePrefix(String word, char ch, String expected) {
        var reversePrefix = new ReversePrefixOfWord();
        assertEquals(expected, reversePrefix.reversePrefix(word, ch));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("abcdefd", 'd', "dcbaefd"),
                Arguments.of("xyxzxe", 'z', "zxyxxe"),
                Arguments.of("abcd", 'z', "abcd"),
                Arguments.of("abcd", 'a', "abcd")
        );
    }

}