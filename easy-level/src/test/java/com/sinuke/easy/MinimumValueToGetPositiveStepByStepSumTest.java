package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumValueToGetPositiveStepByStepSumTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minStartValue(int[] nums, int expected) {
        var solution = new MinimumValueToGetPositiveStepByStepSum();
        assertEquals(expected, solution.minStartValue(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {-3,2,-3,4,2}, 5),
                Arguments.of(new int[] {1,2}, 1),
                Arguments.of(new int[] {1,-2,-3}, 5)
        );
    }

}
