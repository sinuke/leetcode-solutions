package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckIfTwoChessboardSquaresHaveTheSameColorTest {

    @ParameterizedTest
    @MethodSource("testData")
    void checkTwoChessboards(String coordinate1, String coordinate2, boolean expected) {
        var solution = new CheckIfTwoChessboardSquaresHaveTheSameColor();
        assertEquals(expected, solution.checkTwoChessboards(coordinate1, coordinate2));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("a1", "c3", true),
                Arguments.of("a1", "h3", false)
        );
    }

}
