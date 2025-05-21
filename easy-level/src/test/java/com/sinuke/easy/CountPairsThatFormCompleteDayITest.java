package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountPairsThatFormCompleteDayITest {

    @ParameterizedTest
    @MethodSource("testData")
    void countCompleteDayPairs(int[] hours, int expected) {
        var solution = new CountPairsThatFormCompleteDayI();
        assertEquals(expected, solution.countCompleteDayPairs(hours));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {12,12,30,24,24}, 2),
                Arguments.of(new int[] {72,48,24,3}, 3)
        );
    }

}
