package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GreatestEnglishLetterInUpperAndLowerCaseTest {

    @ParameterizedTest
    @MethodSource("testData")
    void greatestLetter(String s, String expected) {
        var solution = new GreatestEnglishLetterInUpperAndLowerCase();
        assertEquals(expected, solution.greatestLetter(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("lEeTcOdE", "E"),
                Arguments.of("arRAzFif", "R"),
                Arguments.of("AbCdEfGhIjK", "")
        );
    }

}
