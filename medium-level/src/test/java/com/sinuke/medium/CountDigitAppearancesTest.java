package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountDigitAppearancesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countDigitOccurrences(int[] nums, int digit, int expected) {
        var solution = new CountDigitAppearances();
        assertEquals(expected, solution.countDigitOccurrences(nums, digit));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{12, 54, 32, 22}, 2, 4),
                Arguments.of(new int[]{1, 34, 7}, 9, 0)
        );
    }

}
