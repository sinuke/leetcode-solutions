package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MergeStringsAlternatelyTest {

    @ParameterizedTest
    @MethodSource("testData")
    void mergeAlternately(String word1, String word2, String expected) {
        var solution = new MergeStringsAlternately();
        assertEquals(expected, solution.mergeAlternately(word1, word2));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("abc", "pqr", "apbqcr"),
                Arguments.of("ab", "pqrs", "apbqrs"),
                Arguments.of("abcd", "pq", "apbqcd")
        );
    }

}
