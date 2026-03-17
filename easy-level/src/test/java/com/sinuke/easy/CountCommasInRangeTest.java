package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountCommasInRangeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countCommas(int n, int expected) {
        var solution = new CountCommasInRange();
        assertEquals(expected, solution.countCommas(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(1002, 3),
                Arguments.of(998, 0)
        );
    }

}
