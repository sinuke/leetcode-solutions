package com.sinuke;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RansomNoteTest {

    @ParameterizedTest
    @MethodSource("testData")
    void canConstruct(String ransomNote, String magazine, boolean expected) {
        var ransom = new RansomNote();
        assertEquals(expected, ransom.canConstruct(ransomNote, magazine));
        assertEquals(expected, ransom.canConstructFromLeetcode(ransomNote, magazine));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("a", "b", false),
                Arguments.of("aa", "ab", false),
                Arguments.of("aa", "aab", true)
        );
    }

}