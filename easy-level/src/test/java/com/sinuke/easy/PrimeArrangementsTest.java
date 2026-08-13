package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrimeArrangementsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void numPrimeArrangements(int n, int expected) {
        var solution = new PrimeArrangements();
        assertEquals(expected, solution.numPrimeArrangements(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(5, 12),
                Arguments.of(100, 682289015)
        );
    }

}
