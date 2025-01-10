package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class LeftAndRightSumDifferencesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void leftRightDifference(int[] nums, int[] expected) {
        var leftAndRightSumDifferences = new LeftAndRightSumDifferences();
        assertArrayEquals(expected, leftAndRightSumDifferences.leftRightDifference(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {10,4,8,3}, new int[] {15,1,11,22}),
                Arguments.of(new int[] {1}, new int[] {0})
        );
    }

}