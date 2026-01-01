package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortArrayByIncreasingFrequencyTest {

    @ParameterizedTest
    @MethodSource("testData")
    void frequencySort(int[] nums, int[] expected) {
        var solution = new SortArrayByIncreasingFrequency();
        assertArrayEquals(expected, solution.frequencySort(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,1,2,2,2,3}, new int[] {3,1,1,2,2,2}),
                Arguments.of(new int[] {2,3,1,3,2}, new int[] {1,3,3,2,2}),
                Arguments.of(new int[] {-1,1,-6,4,5,-6,1,4,1}, new int[] {5,-1,4,4,-6,-6,1,1,1})
        );
    }

}
