package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountBinarySubstringsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countBinarySubstrings(String s, int expected) {
        var solution = new CountBinarySubstrings();
        assertEquals(expected, solution.countBinarySubstrings(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("00110011", 6),
                Arguments.of("10101", 4)
        );
    }

}
