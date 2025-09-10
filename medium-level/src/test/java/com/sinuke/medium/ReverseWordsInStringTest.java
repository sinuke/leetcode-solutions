package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseWordsInStringTest {

    @ParameterizedTest
    @MethodSource("testData")
    void reverseWords(String s, String expected) {
        var solution = new ReverseWordsInString();
        assertEquals(expected, solution.reverseWords(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("the sky is blue", "blue is sky the"),
                Arguments.of("  hello world  ", "world hello"),
                Arguments.of("a good   example", "example good a")
        );
    }

}
