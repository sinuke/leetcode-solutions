package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VerifyingAnAlienDictionaryTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isAlienSorted(String[] words, String order, boolean expected) {
        var solution = new VerifyingAnAlienDictionary();
        assertEquals(expected, solution.isAlienSorted(words, order));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new String[] {"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz", true),
                Arguments.of(new String[] {"word","world","row"}, "worldabcefghijkmnpqstuvxyz", false),
                Arguments.of(new String[] {"apple","app"}, "abcdefghijklmnopqrstuvwxyz", false)
        );
    }

}
