package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DetermineTheWinnerOfBowlingGameTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isWinner(int[] player1, int[] player2, int expected) {
        var solution = new DetermineTheWinnerOfBowlingGame();
        assertEquals(expected, solution.isWinner(player1, player2));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{5, 10, 3, 2}, new int[]{6, 5, 7, 3}, 1),
                Arguments.of(new int[]{3, 5, 7, 6}, new int[]{8, 10, 10, 2}, 2),
                Arguments.of(new int[]{2, 3}, new int[]{4, 1}, 0),
                Arguments.of(new int[]{1, 1, 1, 10, 10, 10, 10}, new int[]{10, 10, 10, 10, 1, 1, 1}, 2)
        );
    }

}
