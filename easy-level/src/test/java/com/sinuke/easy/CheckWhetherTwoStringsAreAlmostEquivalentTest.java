package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckWhetherTwoStringsAreAlmostEquivalentTest {

    @ParameterizedTest
    @MethodSource("testData")
    void checkAlmostEquivalent(String word1, String word2, boolean expected) {
        var solution = new CheckWhetherTwoStringsAreAlmostEquivalent();
        assertEquals(expected, solution.checkAlmostEquivalent(word1, word2));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("aaaa", "bccb", false),
                Arguments.of("abcdeef", "abaaacc", true),
                Arguments.of("cccddabba", "babababab", true)
        );
    }

}
