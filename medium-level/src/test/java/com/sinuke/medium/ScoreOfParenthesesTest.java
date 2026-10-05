package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScoreOfParenthesesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void scoreOfParentheses(String s, int expected) {
        var solution = new ScoreOfParentheses();
        assertEquals(expected, solution.scoreOfParentheses(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("()", 1),
                Arguments.of("(())", 2),
                Arguments.of("()()", 2)
        );
    }

}
