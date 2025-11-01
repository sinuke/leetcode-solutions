package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EqualScoreSubstringsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void scoreBalance(String s, boolean expected) {
        var solution = new EqualScoreSubstrings();
        assertEquals(expected, solution.scoreBalance(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("adcb", true),
                Arguments.of("bace", false)
        );
    }

}
