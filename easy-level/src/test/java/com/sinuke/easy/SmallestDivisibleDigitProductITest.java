package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SmallestDivisibleDigitProductITest {

    @ParameterizedTest
    @MethodSource("testData")
    void smallestNumber(int n, int t, int expected) {
        var solution = new SmallestDivisibleDigitProductI();
        assertEquals(expected, solution.smallestNumber(n, t));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(10, 2, 10),
                Arguments.of(15, 3, 16)
        );
    }

}
