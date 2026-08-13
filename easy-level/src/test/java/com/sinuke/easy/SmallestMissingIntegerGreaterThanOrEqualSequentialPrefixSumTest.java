package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SmallestMissingIntegerGreaterThanOrEqualSequentialPrefixSumTest {

    @ParameterizedTest
    @MethodSource("testData")
    void missingInteger(int[] nums, int expected) {
        var solution = new SmallestMissingIntegerGreaterThanOrEqualSequentialPrefixSum();
        assertEquals(expected, solution.missingInteger(nums));
    }

    static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 2, 5}, 6),
                Arguments.of(new int[]{3, 4, 5, 1, 12, 14, 13}, 15)
        );
    }

}
