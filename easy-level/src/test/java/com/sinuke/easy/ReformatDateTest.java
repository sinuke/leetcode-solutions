package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReformatDateTest {

    @ParameterizedTest
    @MethodSource("testData")
    void reformatDate(String date, String expected) {
        var solution = new ReformatDate();
        assertEquals(expected, solution.reformatDate(date));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("20th Oct 2052", "2052-10-20"),
                Arguments.of("6th Jun 1933", "1933-06-06"),
                Arguments.of("26th May 1960", "1960-05-26")
        );
    }

}
