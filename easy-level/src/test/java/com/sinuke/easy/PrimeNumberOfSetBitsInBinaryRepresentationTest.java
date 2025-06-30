package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrimeNumberOfSetBitsInBinaryRepresentationTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countPrimeSetBits(int left, int right, int expected) {
        var solution = new PrimeNumberOfSetBitsInBinaryRepresentation();
        assertEquals(expected, solution.countPrimeSetBits(left, right));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(6, 10, 4),
                Arguments.of(10, 15, 5)
        );
    }

}
