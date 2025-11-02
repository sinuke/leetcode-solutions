package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GCDOfOddAndEvenSumsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void gcdOfOddEvenSums(int n, int expected) {
        var solution = new GCDOfOddAndEvenSums();
        assertEquals(expected, solution.gcdOfOddEvenSums(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(4, 4),
                Arguments.of(5, 5)
        );
    }

}
