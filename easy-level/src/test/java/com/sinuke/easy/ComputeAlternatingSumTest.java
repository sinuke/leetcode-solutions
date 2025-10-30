package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ComputeAlternatingSumTest {

    @ParameterizedTest
    @MethodSource("testData")
    void alternatingSum(int[] nums, int expected) {
        var solution = new ComputeAlternatingSum();
        assertEquals(expected, solution.alternatingSum(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,3,5,7}, -4),
                Arguments.of(new int[] {100}, 100)
        );
    }

}
