package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumDifferenceBetweenIncreasingElementsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maximumDifference(int[] nums, int expected) {
        var solution = new MaximumDifferenceBetweenIncreasingElements();
        assertEquals(expected, solution.maximumDifference(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {7,1,5,4}, 4),
                Arguments.of(new int[] {9,4,3,2}, -1),
                Arguments.of(new int[] {1,5,2,10}, 9)
        );
    }

}
