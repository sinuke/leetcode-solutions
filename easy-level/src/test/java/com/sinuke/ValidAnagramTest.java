package com.sinuke;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidAnagramTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isAnagram(String s, String t, boolean expected) {
        var anagram = new ValidAnagram();
        assertEquals(expected, anagram.isAnagram(s, t));
        assertEquals(expected, anagram.isAnagramSorting(s, t));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("anagram", "nagaram", true),
                Arguments.of("rat", "car", false)
        );
    }

}
