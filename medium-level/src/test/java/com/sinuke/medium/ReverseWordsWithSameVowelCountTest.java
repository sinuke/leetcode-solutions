package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseWordsWithSameVowelCountTest {

    @ParameterizedTest
    @MethodSource("testData")
    void reverseWords(String s, String expected) {
        assertEquals(expected, new ReverseWordsWithSameVowelCount().reverseWords(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("cat and mice", "cat dna mice"),
                Arguments.of("book is nice", "book is ecin"),
                Arguments.of("banana healthy", "banana healthy")
        );
    }

}
