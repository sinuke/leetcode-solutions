package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReplaceAllDigitsWithCharactersTest {

    @ParameterizedTest
    @MethodSource("testData")
    void replaceDigits(String s, String expected) {
        var solution = new ReplaceAllDigitsWithCharacters();
        assertEquals(expected, solution.replaceDigits(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("a1c1e1", "abcdef"),
                Arguments.of("a1b2c3d4e", "abbdcfdhe")
        );
    }

}
