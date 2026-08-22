package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NearestAvailableDroneTest {

    @ParameterizedTest
    @MethodSource("testData")
    void nearestDrone(int[][] drones, int[] target, int expected) {
        var solution = new NearestAvailableDrone();
        assertEquals(expected, solution.nearestDrone(drones, target));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][]{{0, 0, 8}, {2, 2, 9}}, new int[]{3, 4}, 1),
                Arguments.of(new int[][]{{2, 1, 5}, {4, 4, 5}, {6, 6, 8}}, new int[]{5, 5}, 1),
                Arguments.of(new int[][]{{4, 4, 5}}, new int[]{8, 6}, -1)
        );
    }

}
