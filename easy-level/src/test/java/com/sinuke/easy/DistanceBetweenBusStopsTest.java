package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DistanceBetweenBusStopsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void test(int[] distance, int start, int destination, int expected) {
        var solution = new DistanceBetweenBusStops();
        assertEquals(expected, solution.distanceBetweenBusStops(distance, start, destination));
    }

    static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4}, 0, 1, 1),
                Arguments.of(new int[]{1, 2, 3, 4}, 0, 2, 3),
                Arguments.of(new int[]{1, 2, 3, 4}, 0, 3, 4)
        );
    }

}
