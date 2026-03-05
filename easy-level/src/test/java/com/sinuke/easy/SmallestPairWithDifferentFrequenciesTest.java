package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SmallestPairWithDifferentFrequenciesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minDistinctFreqPair(int[] nums, int[] expected) {
        var solution = new SmallestPairWithDifferentFrequencies();
        assertArrayEquals(expected, solution.minDistinctFreqPair(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,1,2,2,3,4}, new int[] {1,3}),
                Arguments.of(new int[] {1,5}, new int[] {-1,-1}),
                Arguments.of(new int[] {7}, new int[] {-1,-1})
        );
    }

}
