package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveAllOccurrencesOfSubstringTest {

    @ParameterizedTest
    @MethodSource("testData")
    void removeOccurrences(String s, String part, String expected) {
        var solution = new RemoveAllOccurrencesOfSubstring();
        assertEquals(expected, solution.removeOccurrences(s, part));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("daabcbaabcbc", "abc", "dab"),
                Arguments.of("axxxxyyyyb", "xy", "ab"),
                Arguments.of("aabababa", "aba", "ba")
        );
    }

}
