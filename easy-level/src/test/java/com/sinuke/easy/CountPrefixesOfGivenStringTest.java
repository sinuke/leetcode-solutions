package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountPrefixesOfGivenStringTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countPrefixes(String[] words, String s, int expected) {
        var solution = new CountPrefixesOfGivenString();
        assertEquals(expected, solution.countPrefixes(words, s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new String[] {"a","b","c","ab","bc","abc"}, "abc", 3),
                Arguments.of(new String[] {"a","a"}, "aa", 2)
        );
    }

}
