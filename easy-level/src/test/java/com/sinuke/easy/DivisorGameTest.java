package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DivisorGameTest {

    @ParameterizedTest
    @MethodSource("testData")
    void divisorGame(int n, boolean expected) {
        var divisorGame = new DivisorGame();
        assertEquals(expected, divisorGame.divisorGame(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(2, true),
                Arguments.of(3, false)
        );
    }

}
