package com.sinuke;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindIndexFirstOccurrenceStringTest {

    @ParameterizedTest
    @MethodSource("testData")
    void strStr(String haystack, String needle, int expected) {
        var finder = new FindIndexFirstOccurrenceString();

        assertEquals(expected, finder.strStr(haystack, needle));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("sadbutsad", "sad", 0),
                Arguments.of("leetcode", "leeto", -1),
                Arguments.of("mississippi", "issipi", -1),
                Arguments.of("mississippi", "issip", 4),
                Arguments.of("a", "a", 0)
        );
    }

}
