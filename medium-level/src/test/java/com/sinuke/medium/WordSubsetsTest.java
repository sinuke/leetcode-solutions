package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordSubsetsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void wordSubsets(String[] words1, String[] words2, List<String> expected) {
        var wordSubsets = new WordSubsets();
        assertEquals(expected, wordSubsets.wordSubsets(words1, words2));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new String[] {"amazon","apple","facebook","google","leetcode"}, new String[] {"e","o"}, List.of("facebook","google","leetcode")),
                Arguments.of(new String[] {"amazon","apple","facebook","google","leetcode"}, new String[] {"l","e"}, List.of("apple","google","leetcode")),
                Arguments.of(new String[] {"amazon","apple","facebook","google","leetcode"}, new String[] {"e","oo"}, List.of("facebook","google")),
                Arguments.of(new String[] {"amazon","apple","facebook","google","leetcode"}, new String[] {"lo","eo"}, List.of("google","leetcode"))
        );
    }

}
