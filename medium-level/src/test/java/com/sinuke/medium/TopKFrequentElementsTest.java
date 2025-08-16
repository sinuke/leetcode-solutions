package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TopKFrequentElementsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void topKFrequent(int[] nums, int k, int[] expected) {
        var solution = new TopKFrequentElements();
        assertArrayEquals(expected, solution.topKFrequent(nums, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,1,1,2,2,3}, 2, new int[] {1, 2}),
                Arguments.of(new int[] {1}, 1, new int[] {1}),
                Arguments.of(new int[] {-1,-1}, 1, new int[] {-1}),
                Arguments.of(new int[] {3,0,1,0}, 1, new int[] {0})
        );
    }

}
