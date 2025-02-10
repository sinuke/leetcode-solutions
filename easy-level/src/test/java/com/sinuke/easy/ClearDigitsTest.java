package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClearDigitsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void clearDigits(String s, String expected) {
        var solution = new ClearDigits();
        assertEquals(expected, solution.clearDigits(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("abc", "abc"),
                Arguments.of("cb34", "")
        );
    }

}
