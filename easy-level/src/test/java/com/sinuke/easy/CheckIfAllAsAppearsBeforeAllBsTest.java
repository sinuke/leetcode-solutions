package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckIfAllAsAppearsBeforeAllBsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void checkString(String s, boolean expected) {
        var solution = new CheckIfAllAsAppearsBeforeAllBs();
        assertEquals(expected, solution.checkString(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("aaabbb", true),
                Arguments.of("abab", false),
                Arguments.of("bbb", true)
        );
    }

}
