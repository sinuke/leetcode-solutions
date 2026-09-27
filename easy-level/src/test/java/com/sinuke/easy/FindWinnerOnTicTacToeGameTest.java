package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindWinnerOnTicTacToeGameTest {

    @ParameterizedTest
    @MethodSource("testData")
    void tictactoe(int[][] moves, String expected) {
        var solution = new FindWinnerOnTicTacToeGame();
        assertEquals(expected, solution.tictactoe(moves));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][]{{0, 0}, {2, 0}, {1, 1}, {2, 1}, {2, 2}}, "A"),
                Arguments.of(new int[][]{{0, 0}, {1, 1}, {0, 1}, {0, 2}, {1, 0}, {2, 0}}, "B"),
                Arguments.of(new int[][]{{0, 0}, {1, 1}, {2, 0}, {1, 0}, {1, 2}, {2, 1}, {0, 1}, {0, 2}, {2, 2}}, "Draw")
        );
    }

}
