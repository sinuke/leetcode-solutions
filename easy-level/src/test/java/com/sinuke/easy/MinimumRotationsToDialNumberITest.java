package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumRotationsToDialNumberITest {

    @ParameterizedTest
    @MethodSource("testData")
    void minRotations(String s, int expected) {
        var solution = new MinimumRotationsToDialNumberI();
        assertEquals(expected, solution.minRotations(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("0192837465", 25),
                Arguments.of("1200210200", 12)
        );
    }

}
