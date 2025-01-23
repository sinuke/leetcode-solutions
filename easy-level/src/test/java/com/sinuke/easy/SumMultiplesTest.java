package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumMultiplesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void sumOfMultiples(int n, int expected) {
        var sumMultiples = new SumMultiples();
        assertEquals(expected, sumMultiples.sumOfMultiples(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(7, 21),
                Arguments.of(10, 40),
                Arguments.of(9, 30)
        );
    }

}
