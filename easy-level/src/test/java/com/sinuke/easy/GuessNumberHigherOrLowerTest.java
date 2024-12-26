package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GuessNumberHigherOrLowerTest {

    @ParameterizedTest
    @MethodSource("testData")
    void guessNumberHigherOrLower(int n, int pick) {
        var guessNumber = new GuessNumberHigherOrLower(pick);
        assertEquals(pick, guessNumber.guessNumber(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(10, 6),
                Arguments.of(1, 1),
                Arguments.of(2, 1),
                Arguments.of(3, 2)
        );
    }

}
