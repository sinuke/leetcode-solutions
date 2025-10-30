package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumOfElementsWithFrequencyDivisibleByKTest {

    @ParameterizedTest
    @MethodSource("testData")
    void sumDivisibleByK(int[] nums, int k, int expected) {
        var solution = new SumOfElementsWithFrequencyDivisibleByK();
        assertEquals(expected, solution.sumDivisibleByK(nums, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,2,2,3,3,3,3,4}, 2, 16),
                Arguments.of(new int[] {1,2,3,4,5}, 2, 0),
                Arguments.of(new int[] {4,4,4,1,2,3}, 3, 12)
        );
    }

}
