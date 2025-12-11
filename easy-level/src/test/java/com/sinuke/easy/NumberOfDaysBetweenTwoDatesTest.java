package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfDaysBetweenTwoDatesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void daysBetweenDates(String date1, String date2, int expected) {
        var solution = new NumberOfDaysBetweenTwoDates();
        assertEquals(expected, solution.daysBetweenDates(date1, date2));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("2019-06-29", "2019-06-30", 1),
                Arguments.of("2020-01-15", "2019-12-31", 15)
        );
    }

}
