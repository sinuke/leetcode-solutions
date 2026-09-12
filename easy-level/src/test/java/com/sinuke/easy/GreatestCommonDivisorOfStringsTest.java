package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GreatestCommonDivisorOfStringsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void gcdOfStrings(String str1, String str2, String expected) {
        var greatestCommonDivisorOfStrings = new GreatestCommonDivisorOfStrings();
        assertEquals(expected, greatestCommonDivisorOfStrings.gcdOfStrings(str1, str2));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("ABCABC", "ABC", "ABC"),
                Arguments.of("ABABAB", "ABAB", "AB"),
                Arguments.of("LEET", "CODE", ""),
                Arguments.of("AAAAAB", "AAA", "")
        );
    }

}
