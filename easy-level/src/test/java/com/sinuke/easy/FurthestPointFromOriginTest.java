package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FurthestPointFromOriginTest {

    @ParameterizedTest
    @MethodSource("testData")
    void furthestDistanceFromOrigin(String moves, int expected) {
        var solution = new FurthestPointFromOrigin();
        assertEquals(expected, solution.furthestDistanceFromOrigin(moves));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("L_RL__R", 3),
                Arguments.of("_R__LL_", 5),
                Arguments.of("__LR__", 4),
                Arguments.of("LL__RR", 2),
                Arguments.of("_______", 7)
        );
    }

}
