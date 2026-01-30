package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckIfStringIsPrefixOfArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isPrefixString(String s, String[] words, boolean expected) {
        var solution = new CheckIfStringIsPrefixOfArray();
        assertEquals(expected, solution.isPrefixString(s, words));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("iloveleetcode", new String[] {"i","love","leetcode","apples"}, true),
                Arguments.of("iloveleetcode", new String[] {"apples","i","love","leetcode"}, false)
        );
    }

}
