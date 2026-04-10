package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BuddyStringsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void buddyStrings(String s, String goal, boolean expected) {
        assertEquals(expected, new BuddyStrings().buddyStrings(s, goal));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("ab", "ba", true),
                Arguments.of("ab", "ab", false),
                Arguments.of("aa", "aa", true)
        );
    }

}
