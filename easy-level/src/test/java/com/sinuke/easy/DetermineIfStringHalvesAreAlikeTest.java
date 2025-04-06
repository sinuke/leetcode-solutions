package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DetermineIfStringHalvesAreAlikeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void halvesAreAlike(String s, boolean expected) {
        var solution = new DetermineIfStringHalvesAreAlike();
        assertEquals(expected, solution.halvesAreAlike(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("book", true),
                Arguments.of("textbook", false)
        );
    }

}