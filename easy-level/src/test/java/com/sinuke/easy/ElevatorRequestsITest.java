package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ElevatorRequestsITest {

    @ParameterizedTest
    @MethodSource("testData")
    void elevatorRequests(int n, int[] requests, int expected) {
        var solution = new ElevatorRequestsI();
        assertEquals(expected, solution.elevatorRequests(n, requests));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(5, new int[]{2, 1, 4, 3}, 7),
                Arguments.of(3, new int[]{2, 0, 0}, 4)
        );
    }

}
