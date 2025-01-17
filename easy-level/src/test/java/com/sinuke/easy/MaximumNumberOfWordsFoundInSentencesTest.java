package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumNumberOfWordsFoundInSentencesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void mostWordsFound(String[] sentences, int expected) {
        var maxNumberOfWords = new MaximumNumberOfWordsFoundInSentences();
        assertEquals(expected, maxNumberOfWords.mostWordsFound(sentences));
        assertEquals(expected, maxNumberOfWords.mostWordsFound2(sentences));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new String[] {"alice and bob love leetcode", "i think so too", "this is great thanks very much"}, 6),
                Arguments.of(new String[] {"please wait", "continue to fight", "continue to win"}, 3)
        );
    }

}
