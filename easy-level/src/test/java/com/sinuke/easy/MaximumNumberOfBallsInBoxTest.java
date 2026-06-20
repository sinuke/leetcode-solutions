package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumNumberOfBallsInBoxTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countBalls(int lowLimit, int highLimit, int expected) {
        assertEquals(expected, new MaximumNumberOfBallsInBox().countBalls(lowLimit, highLimit));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(1, 10, 2),
                Arguments.of(5, 15, 2),
                Arguments.of(19, 28, 2)
        );
    }

}
