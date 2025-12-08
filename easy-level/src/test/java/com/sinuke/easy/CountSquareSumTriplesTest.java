package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountSquareSumTriplesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countTriples(int n, int expected) {
        var solution = new CountSquareSumTriples();
        assertEquals(expected, solution.countTriples(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(5, 2),
                Arguments.of(10, 4)
        );
    }

}
