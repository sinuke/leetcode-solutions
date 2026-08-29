package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StoneRemovalGameTest {

    @ParameterizedTest
    @MethodSource("testData")
    void canAliceWin(int n, boolean expected) {
        var stoneRemovalGame = new StoneRemovalGame();
        assertEquals(expected, stoneRemovalGame.canAliceWin(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(12, true),
                Arguments.of(1, false)
        );
    }

}
