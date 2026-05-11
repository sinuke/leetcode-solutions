package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ScoreValidatorTest {

    @ParameterizedTest
    @MethodSource("testData")
    void scoreValidator(String[] events, int[] expected) {
        assertArrayEquals(expected, new ScoreValidator().scoreValidator(events));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new String[]{"1", "4", "W", "6", "WD"}, new int[]{12, 1}),
                Arguments.of(new String[]{"WD", "NB", "0", "4", "4"}, new int[]{10, 0}),
                Arguments.of(new String[]{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"}, new int[]{0, 10})
        );
    }

}
