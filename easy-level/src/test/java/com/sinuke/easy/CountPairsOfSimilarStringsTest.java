package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountPairsOfSimilarStringsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void similarPairs(String[] words, int expected) {
        var solution = new CountPairsOfSimilarStrings();
        assertEquals(expected, solution.similarPairs(words));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new String[] {"aba","aabb","abcd","bac","aabc"}, 2),
                Arguments.of(new String[] {"aabb","ab","ba"}, 3),
                Arguments.of(new String[] {"nba","cba","dba"}, 0)
        );
    }

}
