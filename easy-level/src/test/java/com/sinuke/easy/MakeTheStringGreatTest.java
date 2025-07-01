package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MakeTheStringGreatTest {

    @ParameterizedTest
    @MethodSource("testData")
    void makeGood(String s, String expected) {
        var solution =  new MakeTheStringGreat();
        assertEquals(expected, solution.makeGood(s));
        assertEquals(expected, solution.makeGood2(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("leEeetcode", "leetcode"),
                Arguments.of("abBAcC", ""),
                Arguments.of("s", "s")
        );
    }

}
