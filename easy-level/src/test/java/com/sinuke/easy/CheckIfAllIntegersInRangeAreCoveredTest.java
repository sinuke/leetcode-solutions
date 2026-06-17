package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckIfAllIntegersInRangeAreCoveredTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isCovered(int[][] ranges, int left, int right, boolean expected) {
        var solution = new CheckIfAllIntegersInRangeAreCovered();
        assertEquals(expected, solution.isCovered(ranges, left, right));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{1, 2}, {3, 4}, {5, 6}}, 2, 5, true),
                Arguments.of(new int[][] {{1, 10}, {10, 20}}, 21, 21, false)
        );
    }

}
