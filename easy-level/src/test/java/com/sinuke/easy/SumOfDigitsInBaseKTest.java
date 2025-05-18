package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumOfDigitsInBaseKTest {

    @ParameterizedTest
    @MethodSource("testData")
    void sumBase(int n, int k, int expected) {
        var solution = new SumOfDigitsInBaseK();
        assertEquals(expected, solution.sumBase(n, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(34, 6, 9),
                Arguments.of(10, 10, 1)
        );
    }

}
