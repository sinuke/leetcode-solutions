package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindTheNumberOfWinningPlayersTest {

    @ParameterizedTest
    @MethodSource("testData")
    void winningPlayerCount(int n, int[][] pick, int expected) {
        var solution = new FindTheNumberOfWinningPlayers();
        assertEquals(expected, solution.winningPlayerCount(n, pick));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(4, new int[][] {{0,0},{1,0},{1,0},{2,1},{2,1},{2,0}}, 2),
                Arguments.of(5, new int[][] {{1,1},{1,2},{1,3},{1,4}}, 0),
                Arguments.of(5, new int[][] {{1,1},{2,4},{2,4},{2,4}}, 1)
        );
    }

}
