package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumContainersOnShipTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maxContainers(int n, int w, int maxWeight, int expected) {
        var solution = new MaximumContainersOnShip();
        assertEquals(expected, solution.maxContainers(n, w, maxWeight));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(2, 3, 15, 4),
                Arguments.of(3, 5, 20, 4)
        );
    }

}
