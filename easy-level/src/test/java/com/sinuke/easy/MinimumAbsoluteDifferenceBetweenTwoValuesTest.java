package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumAbsoluteDifferenceBetweenTwoValuesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minAbsoluteDifference(int[] nums, int expected) {
        assertEquals(expected, new MinimumAbsoluteDifferenceBetweenTwoValues().minAbsoluteDifference(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{1, 0, 0, 2, 0, 1}, 2),
                Arguments.of(new int[]{1, 0, 1, 0}, -1)
        );
    }

}
