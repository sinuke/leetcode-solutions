package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveZerosInDecimalRepresentationTest {

    @ParameterizedTest
    @MethodSource("testData")
    void removeZeros(long n, long expected) {
        var solution = new RemoveZerosInDecimalRepresentation();
        assertEquals(expected, solution.removeZeros(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(1020030, 123),
                Arguments.of(1, 1)
        );
    }

}
