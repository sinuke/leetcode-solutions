package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferenceBetweenPeaksAndValleysTest {

    @ParameterizedTest
    @MethodSource("testData")
    void peakValleyDifference(int[] nums, int expected) {
        var solution = new DifferenceBetweenPeaksAndValleys();
        assertEquals(expected, solution.peakValleyDifference(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{1, 5, 2, 4, 1, 3, 0}, 9),
                Arguments.of(new int[]{-5, -6, -1, -2, 5, 3, 2}, 12),
                Arguments.of(new int[]{6, 5, 2, 5, 5, 3, 6}, -5)
        );
    }

}
