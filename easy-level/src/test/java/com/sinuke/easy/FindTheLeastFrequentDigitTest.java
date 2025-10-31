package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindTheLeastFrequentDigitTest {

    @ParameterizedTest
    @MethodSource("testData")
    void getLeastFrequentDigit(int n, int expected) {
        var solution = new FindTheLeastFrequentDigit();
        assertEquals(expected, solution.getLeastFrequentDigit(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(1553322, 1),
                Arguments.of(723344511, 2),
                Arguments.of(10, 0)
        );
    }

}
