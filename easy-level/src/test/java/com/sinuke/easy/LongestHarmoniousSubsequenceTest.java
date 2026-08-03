package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestHarmoniousSubsequenceTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findLHS(int[] nums, int expected) {
        var solution = new LongestHarmoniousSubsequence();
        assertEquals(expected, solution.findLHS(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 2, 2, 5, 2, 3, 7}, 5),
                Arguments.of(new int[]{1, 2, 3, 4}, 2),
                Arguments.of(new int[]{1, 1, 1, 1}, 0)
        );
    }

}