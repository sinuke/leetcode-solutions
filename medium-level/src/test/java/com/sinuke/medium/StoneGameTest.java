package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StoneGameTest {

    @ParameterizedTest
    @MethodSource("testData")
    void stoneGame(int[] piles, boolean expected) {
        var solution = new StoneGame();
        assertEquals(expected, solution.stoneGame(piles));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{5, 3, 4, 5}, true),
                Arguments.of(new int[]{3, 7, 2, 3}, true)
        );
    }

}
