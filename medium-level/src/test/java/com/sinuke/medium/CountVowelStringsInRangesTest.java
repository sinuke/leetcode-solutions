package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class CountVowelStringsInRangesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void vowelStrings(String[] words, int[][] queries, int[] expected) {
        var countVowelStringsInRanges = new CountVowelStringsInRanges();
        assertArrayEquals(expected, countVowelStringsInRanges.vowelStrings(words, queries));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new String[] {"aba","bcb","ece","aa","e"}, new int[][] {{0,2},{1,4},{1,1}}, new int[] {2,3,0}),
                Arguments.of(new String[] {"a","e","i"}, new int[][] {{0,2},{0,1},{2,2}}, new int[] {3,2,1})
        );
    }

}