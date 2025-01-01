package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumScoreAfterSplittingStringTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maxScore(String s, int expected) {
        var maximumScore = new MaximumScoreAfterSplittingString();
        assertEquals(expected, maximumScore.maxScore(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("011101", 5),
                Arguments.of("00111", 5),
                Arguments.of("1111", 3),
                Arguments.of("00", 1),
                Arguments.of("10", 0)
        );
    }

}
