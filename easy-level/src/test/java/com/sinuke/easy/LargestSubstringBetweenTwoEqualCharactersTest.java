package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LargestSubstringBetweenTwoEqualCharactersTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maxLengthBetweenEqualCharacters(String s, int expected) {
        var solution = new LargestSubstringBetweenTwoEqualCharacters();
        assertEquals(expected, solution.maxLengthBetweenEqualCharacters(s));
        assertEquals(expected, solution.maxLengthBetweenEqualCharacters2(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("aa", 0),
                Arguments.of("abca", 2),
                Arguments.of("cbzxy", -1),
                Arguments.of("scayofdzca", 6)
        );
    }

}
