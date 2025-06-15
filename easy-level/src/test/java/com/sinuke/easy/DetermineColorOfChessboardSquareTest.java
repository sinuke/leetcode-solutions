package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DetermineColorOfChessboardSquareTest {

    @ParameterizedTest
    @MethodSource("testData")
    void squareIsWhite(String coordinates, boolean expected) {
        var solution = new DetermineColorOfChessboardSquare();
        assertEquals(expected, solution.squareIsWhite(coordinates));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("a1", false),
                Arguments.of("h3", true),
                Arguments.of("c7", false)
        );
    }

}
