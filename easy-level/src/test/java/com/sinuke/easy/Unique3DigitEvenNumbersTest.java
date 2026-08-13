package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Unique3DigitEvenNumbersTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countNumbers(int[] input, int expected) {
        var solution = new Unique3DigitEvenNumbers();
        assertEquals(expected, solution.totalNumbers(input));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1, 2, 3, 4}, 12),
                Arguments.of(new int[] {0, 2, 2}, 2),
                Arguments.of(new int[] {6, 6, 6}, 1),
                Arguments.of(new int[] {1, 3, 5}, 0)
        );
    }

}
