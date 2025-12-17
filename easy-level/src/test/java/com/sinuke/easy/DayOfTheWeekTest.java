package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayOfTheWeekTest {

    @ParameterizedTest
    @MethodSource("testData")
    void dayOfTheWeek(int day, int month, int year, String expected) {
        var solution = new DayOfTheWeek();
        assertEquals(expected, solution.dayOfTheWeek(day, month, year));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(31, 8, 2019, "Saturday"),
                Arguments.of(18, 7, 1999, "Sunday"),
                Arguments.of(15, 8, 1993, "Sunday")
        );
    }

}
