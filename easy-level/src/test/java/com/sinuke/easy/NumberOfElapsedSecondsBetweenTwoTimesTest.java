package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfElapsedSecondsBetweenTwoTimesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void secondsBetweenTimes(String startTime, String endTime, int expected) {
        assertEquals(expected, new NumberOfElapsedSecondsBetweenTwoTimes().secondsBetweenTimes(startTime, endTime));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("01:00:00", "01:00:25", 25),
                Arguments.of("12:34:56", "13:00:00", 1504)
        );
    }

}
