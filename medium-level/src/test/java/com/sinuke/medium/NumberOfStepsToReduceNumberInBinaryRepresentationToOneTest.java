package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfStepsToReduceNumberInBinaryRepresentationToOneTest {

    @ParameterizedTest
    @MethodSource("testData")
    void numSteps(String s, int expected) {
        var solution = new NumberOfStepsToReduceNumberInBinaryRepresentationToOne();
        assertEquals(expected, solution.numSteps(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("1101", 6),
                Arguments.of("10", 1),
                Arguments.of("1", 0)
        );
    }

}
