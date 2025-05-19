package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumOddBinaryNumberTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maximumOddBinaryNumber(String s, String expected) {
        var solution = new MaximumOddBinaryNumber();
        assertEquals(expected, solution.maximumOddBinaryNumber(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("010", "001"),
                Arguments.of("0101", "1001")
        );
    }

}
