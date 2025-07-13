package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DetectCapitalTest {

    @ParameterizedTest
    @MethodSource("testData")
    void detectCapitalUse(String word, boolean expected) {
        var solution = new DetectCapital();
        assertEquals(expected, solution.detectCapitalUse(word));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("USA", true),
                Arguments.of("FlaG", false)
        );
    }

}
