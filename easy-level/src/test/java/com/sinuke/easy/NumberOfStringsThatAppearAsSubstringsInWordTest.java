package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfStringsThatAppearAsSubstringsInWordTest {

    @ParameterizedTest
    @MethodSource("testData")
    void numOfStrings(String[] patterns, String word, int expected) {
        var solution = new NumberOfStringsThatAppearAsSubstringsInWord();
        assertEquals(expected, solution.numOfStrings(patterns, word));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new String[] {"a","abc","bc","d"}, "abc", 3),
                Arguments.of(new String[] {"a","b","c"}, "aaaaabbbbb", 2),
                Arguments.of(new String[] {"a","a","a"}, "ab", 3)
        );
    }

}