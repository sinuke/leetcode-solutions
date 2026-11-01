package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryDigitScoreTest {

    @ParameterizedTest
    @MethodSource("testData")
    void calculateScore(int a, int b, int expected) {
        var solution = new BinaryDigitScore();
        assertEquals(expected, solution.calculateScore(a, b));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(14, 6, 6),
                Arguments.of(5, 15, 2),
                Arguments.of(10, 12, 4)
        );
    }

}
