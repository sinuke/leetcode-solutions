package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AverageWaitingTimeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void averageWaitingTime(int[][] customers, double expected) {
        var solution = new AverageWaitingTime();
        assertEquals(expected, solution.averageWaitingTime(customers), 0.00001);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{1,2},{2,5},{4,3}}, 5.00000),
                Arguments.of(new int[][] {{5,2},{5,4},{10,3},{20,1}}, 3.25000),
                Arguments.of(new int[][] {{2,3},{6,3},{7,5},{11,3},{15,2},{18,1}}, 4.16667)
        );
    }

}
