package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BackspaceStringCompareTest {

    @ParameterizedTest
    @MethodSource("testData")
    void backspaceCompare(String s, String t, boolean expected) {
        var solution = new BackspaceStringCompare();
        assertEquals(expected, solution.backspaceCompare(s, t));
        assertEquals(expected, solution.backspaceCompare2(s, t));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("ab#c", "ad#c", true),
                Arguments.of("ab##", "c#d#", true),
                Arguments.of("a#c", "b", false)
        );
    }

}
