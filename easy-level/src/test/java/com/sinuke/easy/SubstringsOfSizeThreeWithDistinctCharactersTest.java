package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SubstringsOfSizeThreeWithDistinctCharactersTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countGoodSubstrings(String s, int expected) {
        var solution = new SubstringsOfSizeThreeWithDistinctCharacters();
        assertEquals(expected, solution.countGoodSubstrings(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("xyzzaz", 1),
                Arguments.of("aababcabc", 4)
        );
    }

}
