package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfValidClockTimesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countTime(String time, int expected) {
        var solution = new NumberOfValidClockTimes();
        assertEquals(expected, solution.countTime(time));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("?5:00", 2),
                Arguments.of("0?:0?", 100),
                Arguments.of("??:??", 1440),
                Arguments.of("00:0?", 10),
                Arguments.of("00:00", 1),
                Arguments.of("2?:??", 240)
        );
    }

}
