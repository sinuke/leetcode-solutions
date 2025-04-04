package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountPartitionsWithEvenSumDifferenceTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countPartitions(int[] nums, int expected) {
        var solution = new CountPartitionsWithEvenSumDifference();
        assertEquals(expected, solution.countPartitions(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{10,10,3,7,6}, 4),
                Arguments.of(new int[]{1,2,2}, 0),
                Arguments.of(new int[]{2,4,6,8}, 3)
        );
    }

}
