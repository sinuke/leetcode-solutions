package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindThePivotIntegerTest {

    @ParameterizedTest
    @MethodSource("testData")
    void pivotInteger(int n, int expected) {
        var solution = new FindThePivotInteger();
        assertEquals(expected, solution.pivotInteger(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(8, 6),
                Arguments.of(1, 1),
                Arguments.of(4, -1)
        );
    }

}
