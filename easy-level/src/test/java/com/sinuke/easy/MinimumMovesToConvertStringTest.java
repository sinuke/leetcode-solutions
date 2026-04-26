package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumMovesToConvertStringTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minimumMoves(String s, int expected) {
        assertEquals(expected, new MinimumMovesToConvertString().minimumMoves(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("XXX", 1),
                Arguments.of("XXOX", 2),
                Arguments.of("OOOO", 0)
        );
    }

}
