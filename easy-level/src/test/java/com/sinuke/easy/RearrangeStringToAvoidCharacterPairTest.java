package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RearrangeStringToAvoidCharacterPairTest {

    @ParameterizedTest
    @MethodSource("testData")
    void rearrangeString(String s, char x, char y, String expected) {
        var solution = new RearrangeStringToAvoidCharacterPair();
        assertEquals(expected, solution.rearrangeString(s, x, y));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("aabc", 'a', 'c', "cbaa"),
                Arguments.of("dcab", 'd', 'b', "bcad"),
                Arguments.of("axe", 'o', 'x', "xae")
        );
    }

}
