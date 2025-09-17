package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountNumberOfDistinctIntegersAfterReverseOperationsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countDistinctIntegers(int[] nums, int expected) {
        var solution = new CountNumberOfDistinctIntegersAfterReverseOperations();
        assertEquals(expected, solution.countDistinctIntegers(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,13,10,12,31}, 6),
                Arguments.of(new int[] {2,2,2}, 1)
        );
    }

}