package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class DigitFrequencyScoreTest {

    @ParameterizedTest
    @MethodSource("testData")
    void digitFrequencyScore(int n, int expected) {
        var solution = new DigitFrequencyScore();
        assertEquals(expected, solution.digitFrequencyScore(n));
        assertEquals(expected, solution.digitFrequencyScore2(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(122, 5),
                Arguments.of(101, 2)
        );
    }

}
