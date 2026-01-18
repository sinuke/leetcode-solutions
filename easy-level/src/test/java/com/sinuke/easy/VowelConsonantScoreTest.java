package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VowelConsonantScoreTest {

    @ParameterizedTest
    @MethodSource("testData")
    void vowelConsonantScore(String s, int expected) {
        var solution = new VowelConsonantScore();
        assertEquals(expected, solution.vowelConsonantScore(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("cooear", 2),
                Arguments.of("axeyizou", 1),
                Arguments.of("au 123", 0)
        );
    }

}
