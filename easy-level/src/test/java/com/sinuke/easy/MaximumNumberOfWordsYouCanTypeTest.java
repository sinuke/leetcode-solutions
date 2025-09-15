package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumNumberOfWordsYouCanTypeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void canBeTypedWords(String text, String brokenLetters, int expected) {
        var solution = new MaximumNumberOfWordsYouCanType();
        assertEquals(expected, solution.canBeTypedWords(text, brokenLetters));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("hello world", "ad", 1),
                Arguments.of("leet code", "lt", 1),
                Arguments.of("leet code", "e", 0)
        );
    }

}
