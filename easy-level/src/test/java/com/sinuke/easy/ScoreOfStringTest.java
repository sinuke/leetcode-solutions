package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScoreOfStringTest {

    @ParameterizedTest
    @MethodSource("testData")
    void scoreOfString(String s, int expected) {
        var score = new ScoreOfString();
        assertEquals(expected, score.scoreOfString(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("hello", 13),
                Arguments.of("zaz", 50)
        );
    }

}
