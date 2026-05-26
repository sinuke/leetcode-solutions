package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PushDominoesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void pushDominoes(String dominoes, String expected) {
        assertEquals(expected, new PushDominoes().pushDominoes(dominoes));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("RR.L", "RR.L"),
                Arguments.of(".L.R...LR..L..", "LL.RR.LLRRLL.."),
                Arguments.of("R......L", "RRRRLLLL"),
                Arguments.of("R.R.L", "RRR.L"),
                Arguments.of("R.R.L.L", "RRR.LLL"),
                Arguments.of("L.....RR.RL.....L.R.", "L.....RRRRLLLLLLL.RR")
        );
    }

}
