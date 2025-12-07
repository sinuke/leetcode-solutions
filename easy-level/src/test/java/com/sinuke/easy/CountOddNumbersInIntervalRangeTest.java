package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountOddNumbersInIntervalRangeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countOdds(int low, int high, int expected) {
        var solution = new CountOddNumbersInIntervalRange();
        assertEquals(expected, solution.countOdds(low, high));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(3, 7, 3),
                Arguments.of(8, 10, 1)
        );
    }

}
