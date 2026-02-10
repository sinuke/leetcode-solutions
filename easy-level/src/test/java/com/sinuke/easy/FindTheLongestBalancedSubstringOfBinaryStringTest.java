package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindTheLongestBalancedSubstringOfBinaryStringTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findTheLongestBalancedSubstring(String s, int expected) {
        var solution = new FindTheLongestBalancedSubstringOfBinaryString();
        assertEquals(expected, solution.findTheLongestBalancedSubstring(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("01000111", 6),
                Arguments.of("00111", 4),
                Arguments.of("111", 0)
        );
    }

}
