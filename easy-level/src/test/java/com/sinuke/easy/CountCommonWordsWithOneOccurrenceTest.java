package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountCommonWordsWithOneOccurrenceTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countWords(String[] words1, String[] words2, int expected) {
        var solution = new CountCommonWordsWithOneOccurrence();
        assertEquals(expected, solution.countWords(words1, words2));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new String[] {"leetcode","is","amazing","as","is"}, new String[] {"amazing","leetcode","is"}, 2),
                Arguments.of(new String[] {"b","bb","bbb"}, new String[] {"a","aa","aaa"}, 0),
                Arguments.of(new String[] {"a","ab"}, new String[] {"a","a","a","ab"}, 1)
        );
    }

}
