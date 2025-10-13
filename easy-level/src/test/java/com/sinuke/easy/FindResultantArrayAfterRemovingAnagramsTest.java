package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindResultantArrayAfterRemovingAnagramsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void removeAnagrams(String[] words, List<String> expected) {
        var solution = new FindResultantArrayAfterRemovingAnagrams();
        assertEquals(expected, solution.removeAnagrams(words));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new String[] {"abba","baba","bbaa","cd","cd"}, List.of("abba","cd")),
                Arguments.of(new String[] {"a","b","c","d","e"}, List.of("a","b","c","d","e")),
                Arguments.of(new String[] {"a","b","a"}, List.of("a","b","a"))
        );
    }

}
