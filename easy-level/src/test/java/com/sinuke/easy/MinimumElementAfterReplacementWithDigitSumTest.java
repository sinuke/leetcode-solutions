package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumElementAfterReplacementWithDigitSumTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minElement(int[] nums, int expected) {
        var solution = new MinimumElementAfterReplacementWithDigitSum();
        assertEquals(expected, solution.minElement(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {10,12,13,14}, 1),
                Arguments.of(new int[] {1,2,3,4}, 1),
                Arguments.of(new int[] {999,19,199}, 10)
        );
    }

}
