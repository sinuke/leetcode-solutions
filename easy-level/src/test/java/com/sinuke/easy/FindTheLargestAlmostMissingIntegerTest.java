package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindTheLargestAlmostMissingIntegerTest {

    @ParameterizedTest
    @MethodSource("testData")
    void largestInteger(int[] nums, int k, int expected) {
        var solution = new FindTheLargestAlmostMissingInteger();
        assertEquals(expected, solution.largestInteger(nums, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {3, 9, 2, 1, 7}, 3, 7),
                Arguments.of(new int[] {3, 9, 7, 2, 1, 7}, 4, 3),
                Arguments.of(new int[] {0, 0}, 1, -1)
        );
    }

}
