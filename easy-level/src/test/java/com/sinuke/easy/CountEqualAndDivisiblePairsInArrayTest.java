package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountEqualAndDivisiblePairsInArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countPairs(int[] nums, int k, int expected) {
        var solution = new CountEqualAndDivisiblePairsInArray();
        assertEquals(expected, solution.countPairs(nums, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {3,1,2,2,2,1,3}, 2, 4),
                Arguments.of(new int[] {1,2,3,4}, 1, 0)
        );
    }

}
