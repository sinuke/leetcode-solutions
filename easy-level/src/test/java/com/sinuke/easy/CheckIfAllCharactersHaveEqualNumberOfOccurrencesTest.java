package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckIfAllCharactersHaveEqualNumberOfOccurrencesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void areOccurrencesEqual(String s, boolean expected) {
        var solution = new CheckIfAllCharactersHaveEqualNumberOfOccurrences();
        assertEquals(expected, solution.areOccurrencesEqual(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("abacbc", true),
                Arguments.of("aaabb", false)
        );
    }

}
