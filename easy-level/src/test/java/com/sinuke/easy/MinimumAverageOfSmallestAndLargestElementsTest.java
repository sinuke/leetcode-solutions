package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumAverageOfSmallestAndLargestElementsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minimumAverage(int[] nums, double expected) {
        var solution = new MinimumAverageOfSmallestAndLargestElements();
        assertEquals(expected, solution.minimumAverage(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {7,8,3,4,15,13,4,1}, 5.5d),
                Arguments.of(new int[] {1,9,8,3,10,5}, 5.5d),
                Arguments.of(new int[] {1,2,3,7,8,9}, 5.0d)
        );
    }

}
