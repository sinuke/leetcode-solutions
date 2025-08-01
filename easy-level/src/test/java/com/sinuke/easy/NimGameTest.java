package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NimGameTest {

    @ParameterizedTest
    @MethodSource("testData")
    void canWinNim(int n, boolean expected) {
        var solution = new NimGame();
        assertEquals(expected, solution.canWinNim(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(4, false),
                Arguments.of(5, true),
                Arguments.of(2, true)
        );
    }

}
