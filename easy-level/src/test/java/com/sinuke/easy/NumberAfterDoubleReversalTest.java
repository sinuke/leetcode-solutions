package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberAfterDoubleReversalTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isSameAfterReversals(int num, boolean expected) {
        var solution = new NumberAfterDoubleReversal();
        assertEquals(expected, solution.isSameAfterReversals(num));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(526, true),
                Arguments.of(1800, false),
                Arguments.of(0, true)
        );
    }

}
