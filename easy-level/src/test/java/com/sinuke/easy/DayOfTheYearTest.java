package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayOfTheYearTest {

    @ParameterizedTest
    @MethodSource("testData")
    void dayOfYear(String date, int expected) {
        var solution = new DayOfTheYear();
        assertEquals(expected, solution.dayOfYear(date));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("2019-01-09", 9),
                Arguments.of("2019-02-10", 41)
        );
    }

}
