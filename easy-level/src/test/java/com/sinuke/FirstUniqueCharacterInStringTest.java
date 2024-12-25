package com.sinuke;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FirstUniqueCharacterInStringTest {

    @ParameterizedTest
    @MethodSource("testData")
    void firstUniqChar(String s, int expected) {
        var firstUniqChar = new FirstUniqueCharacterInString();
        assertEquals(expected, firstUniqChar.firstUniqChar(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("leetcode", 0),
                Arguments.of("loveleetcode", 2),
                Arguments.of("aabb", -1),
                Arguments.of("abab", -1),
                Arguments.of("ababc", 4),
                Arguments.of("a", 0),
                Arguments.of("aaaaaa", -1)
        );
    }

}