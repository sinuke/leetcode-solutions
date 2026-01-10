package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindTheMaximumDivisibilityScoreTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maxDivScore(int[] nums, int[] divisors, int expected) {
        var solution = new FindTheMaximumDivisibilityScore();
        assertEquals(expected, solution.maxDivScore(nums, divisors));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {2,9,15,50}, new int[] {5,3,7,2}, 2),
                Arguments.of(new int[] {4,7,9,3,9}, new int[] {5,2,3}, 3),
                Arguments.of(new int[] {20,14,21,10}, new int[] {10,16,20}, 10)
        );
    }

}
