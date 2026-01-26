package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumDifferenceBetweenHighestAndLowestOfKScoresTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minimumDifference(int[] nums, int k, int expected) {
        var solution = new MinimumDifferenceBetweenHighestAndLowestOfKScores();
        assertEquals(expected, solution.minimumDifference(nums, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {90}, 1, 0),
                Arguments.of(new int[] {9,4,1,7}, 2, 2)
        );
    }

}
