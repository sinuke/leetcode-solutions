package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThousandSeparatorTest {

    @ParameterizedTest
    @MethodSource("testData")
    void thousandSeparator(int n, String expected) {
        var solution = new ThousandSeparator();
        assertEquals(expected, solution.thousandSeparator(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(987, "987"),
                Arguments.of(1234, "1.234"),
                Arguments.of(0, "0"),
                Arguments.of(1234246723, "1.234.246.723")
        );
    }

}
