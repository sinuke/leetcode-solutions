package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrimTrailingVowelsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void trimTrailingVowels(String s, String expected) {
        var solution = new TrimTrailingVowels();
        assertEquals(expected, solution.trimTrailingVowels(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("idea", "id"),
                Arguments.of("day", "day"),
                Arguments.of("aeiou", "")
        );
    }

}
