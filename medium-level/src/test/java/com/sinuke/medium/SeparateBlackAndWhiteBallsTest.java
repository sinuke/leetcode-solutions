package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SeparateBlackAndWhiteBallsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minimumSteps(String s, long expected) {
        assertEquals(expected, new SeparateBlackAndWhiteBalls().minimumSteps(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("101", 1L),
                Arguments.of("100", 2L),
                Arguments.of("0111", 0L)
        );
    }

}
