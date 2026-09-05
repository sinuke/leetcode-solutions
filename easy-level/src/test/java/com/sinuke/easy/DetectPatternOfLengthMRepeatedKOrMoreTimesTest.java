package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DetectPatternOfLengthMRepeatedKOrMoreTimesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void containsPattern(int[] arr, int m, int k, boolean expected) {
        var solution = new DetectPatternOfLengthMRepeatedKOrMoreTimes();
        assertEquals(expected, solution.containsPattern(arr, m, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 4, 4, 4, 4}, 1, 3, true),
                Arguments.of(new int[]{1, 2, 1, 2, 1, 1, 1, 3}, 2, 2, true),
                Arguments.of(new int[]{1, 2, 1, 2, 1, 3}, 2, 3, false)
        );
    }

}
