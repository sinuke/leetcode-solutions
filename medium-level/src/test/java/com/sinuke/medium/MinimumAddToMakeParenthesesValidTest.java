package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumAddToMakeParenthesesValidTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minAddToMakeValid(String s, int expected) {
        var solution = new MinimumAddToMakeParenthesesValid();
        assertEquals(expected, solution.minAddToMakeValid(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("())", 1),
                Arguments.of("(((", 3)
        );
    }

}
