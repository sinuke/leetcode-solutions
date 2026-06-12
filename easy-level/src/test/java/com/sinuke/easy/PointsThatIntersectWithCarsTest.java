package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

class PointsThatIntersectWithCarsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void numberOfPoints(List<List<Integer>> nums, int expected) {
        assertEquals(expected, new PointsThatIntersectWithCars().numberOfPoints(nums));
    }

    private static Stream<org.junit.jupiter.params.provider.Arguments> testData() {
        return Stream.of(
                of(Arrays.asList(List.of(3, 6), List.of(1, 5), List.of(4, 7)), 7),
                of(Arrays.asList(List.of(1, 3), List.of(5, 8)), 7)
        );
    }

}
