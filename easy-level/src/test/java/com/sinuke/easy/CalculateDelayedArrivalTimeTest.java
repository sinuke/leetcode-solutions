package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculateDelayedArrivalTimeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findDelayedArrivalTime(int arrivalTime, int delayedTime, int expected) {
        var solution = new CalculateDelayedArrivalTime();
        assertEquals(expected, solution.findDelayedArrivalTime(arrivalTime, delayedTime));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(15, 5, 20),
                Arguments.of(13, 11, 0)
        );
    }

}
