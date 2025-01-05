package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountNumberOfConsistentStringsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countConsistentStrings(String allowed, String[] words, int expected) {
        var counter = new CountNumberOfConsistentStrings();
        assertEquals(expected, counter.countConsistentStrings(allowed, words));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("ab", new String[] {"ad","bd","aaab","baa","badab"}, 2),
                Arguments.of("abc", new String[] {"a","b","c","ab","ac","bc","abc"}, 7),
                Arguments.of("cad", new String[] {"cc","acd","b","ba","bac","bad","ac","d"}, 4)
        );
    }

}
