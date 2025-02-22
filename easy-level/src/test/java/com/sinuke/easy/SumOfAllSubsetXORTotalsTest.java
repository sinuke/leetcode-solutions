package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumOfAllSubsetXORTotalsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void subsetXORSum(int[] nums, int expected) {
        var solution = new SumOfAllSubsetXORTotals();
        assertEquals(expected, solution.subsetXORSum(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,3}, 6),
                Arguments.of(new int[] {5,1,6}, 28),
                Arguments.of(new int[] {3,4,5,6,7,8}, 480)
        );
    }

}
