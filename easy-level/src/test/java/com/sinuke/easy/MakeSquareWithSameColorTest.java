package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MakeSquareWithSameColorTest {

    @ParameterizedTest
    @MethodSource("testData")
    void canMakeSquare(char[][] grid, boolean expected) {
        assertEquals(expected, new MakeSquareWithSameColor().canMakeSquare(grid));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new char[][]{{'B','W','B'},{'B','W','W'},{'B','W','B'}}, true),
                Arguments.of(new char[][]{{'B','W','B'},{'W','B','W'},{'B','W','B'}}, false),
                Arguments.of(new char[][]{{'B','W','B'},{'B','W','W'},{'B','W','W'}}, true)
        );
    }

}
