package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfStepsToReduceNumberToZeroTest {

    @ParameterizedTest
    @MethodSource("testData")
    void numberOfSteps(int num, int expected) {
        var number = new NumberOfStepsToReduceNumberToZero();
        assertEquals(expected, number.numberOfSteps(num));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(14, 6),
                Arguments.of(8, 4),
                Arguments.of(123, 12)
        );
    }

}
