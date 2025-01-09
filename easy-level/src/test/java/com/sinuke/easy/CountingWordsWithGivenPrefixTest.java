package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountingWordsWithGivenPrefixTest {

    @ParameterizedTest
    @MethodSource("testData")
    void prefixCount(String[] words, String pref, int expected) {
        var counting = new CountingWordsWithGivenPrefix();
        assertEquals(expected, counting.prefixCount(words, pref));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new String[] {"pay","attention","practice","attend"}, "at", 2),
                Arguments.of(new String[] {"leetcode","win","loops","success"}, "code", 0)
        );
    }

}
