package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountNumberOfPairsWithAbsoluteDifferenceKTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countKDifference(int[] nums, int k, int expected) {
        var counter = new CountNumberOfPairsWithAbsoluteDifferenceK();
        assertEquals(expected, counter.countKDifference(nums, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,2,2,1}, 1, 4),
                Arguments.of(new int[] {1,3}, 3, 0),
                Arguments.of(new int[] {3,2,1,5,4}, 2, 3)
        );
    }

}
