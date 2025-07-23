package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RotateStringTest {

    @ParameterizedTest
    @MethodSource("testData")
    void rotateString(String s, String goal, boolean expected) {
        var solution = new RotateString();
        assertEquals(expected, solution.rotateString(s, goal));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("abcde", "cdeab", true),
                Arguments.of("abcde", "abced", false)
        );
    }

}
