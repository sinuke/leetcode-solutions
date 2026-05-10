package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppendCharactersToStringToMakeSubsequenceTest {

    @ParameterizedTest
    @MethodSource("testData")
    void appendCharacters(String s, String t, int expected) {
        var solution = new AppendCharactersToStringToMakeSubsequence();
        assertEquals(expected, solution.appendCharacters(s, t));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("coaching", "coding", 4),
                Arguments.of("abcde", "a", 0),
                Arguments.of("z", "abcde", 5)
        );
    }

}
