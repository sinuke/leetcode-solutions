package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LetterTilePossibilitiesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void numTilePossibilities(String tiles, int expected) {
        var solution = new LetterTilePossibilities();
        assertEquals(expected, solution.numTilePossibilities(tiles));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("AAB", 8),
                Arguments.of("AAABBC", 188),
                Arguments.of("V", 1)
        );
    }

}
