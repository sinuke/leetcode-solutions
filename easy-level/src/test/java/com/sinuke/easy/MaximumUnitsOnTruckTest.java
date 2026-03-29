package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumUnitsOnTruckTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maximumUnits(int[][] boxTypes, int truckSize, int expected) {
        var solution = new MaximumUnitsOnTruck();
        assertEquals(expected, solution.maximumUnits(boxTypes, truckSize));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 3}, {2, 2}, {3, 1}}, 4, 8),
                Arguments.of(new int[][]{{5, 10}, {2, 5}, {4, 7}, {3, 9}}, 10, 91)
        );
    }
    
}
