package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindTheWinningPlayerInCoinGameTest {

    @ParameterizedTest
    @MethodSource("testData")
    void losingPlayer(int x, int y, String expected) {
        var solution = new FindTheWinningPlayerInCoinGame();
        assertEquals(expected, solution.winningPlayer(x, y));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(2, 7, "Alice"),
                Arguments.of(4, 11, "Bob")
        );
    }

}
