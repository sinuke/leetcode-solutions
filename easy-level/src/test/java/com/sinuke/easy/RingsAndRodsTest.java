package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RingsAndRodsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countPoints(String rings, int expected) {
        var solution = new RingsAndRods();
        assertEquals(expected, solution.countPoints(rings));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("B0B6G0R6R0R6G9", 1),
                Arguments.of("B0R0G0R9R0B0G0", 1),
                Arguments.of("G4", 0)
        );
    }

}
