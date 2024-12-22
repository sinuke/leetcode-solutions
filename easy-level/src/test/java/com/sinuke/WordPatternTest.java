package com.sinuke;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordPatternTest {

    @ParameterizedTest
    @MethodSource("testData")
    void wordPattern(String pattern, String s, boolean expected) {
        var wordPattern = new WordPattern();
        assertEquals(expected, wordPattern.wordPattern(pattern, s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("abba", "dog cat cat dog", true),
                Arguments.of("abba", "dog cat cat fish", false),
                Arguments.of("aaaa", "dog cat cat dog", false),
                Arguments.of("abcb", "dog cat dog cat", false),
                Arguments.of("abcb", "dog cat hat cat", true)
        );
    }

}
