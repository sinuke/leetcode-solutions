package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AngleBetweenHandsOfClockTest {

    @ParameterizedTest
    @MethodSource("testData")
    void angleClock(int hour, int minutes, double expected) {
        assertEquals(expected, new AngleBetweenHandsOfClock().angleClock(hour, minutes));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(12, 30, 165.0),
                Arguments.of(3, 30, 75.0),
                Arguments.of(3, 15, 7.5),
                Arguments.of(1, 57, 76.5),
                Arguments.of(8, 7, 158.5)
        );
    }

}
