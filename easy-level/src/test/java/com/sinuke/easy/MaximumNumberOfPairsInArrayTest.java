package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MaximumNumberOfPairsInArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void numberOfPairs(int[] nums, int[] expected) {
        var solution = new MaximumNumberOfPairsInArray();
        assertArrayEquals(expected,solution.numberOfPairs(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,3,2,1,3,2,2}, new int[] {3,1}),
                Arguments.of(new int[] {1,1}, new int[] {1,0}),
                Arguments.of(new int[] {0}, new int[] {0,1})
        );
    }

}
