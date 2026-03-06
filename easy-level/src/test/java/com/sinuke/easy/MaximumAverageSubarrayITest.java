package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumAverageSubarrayITest {

    @ParameterizedTest
    @MethodSource("testData")
    void findMaxAverage(int[] nums, int k, double expected) {
        var solution = new MaximumAverageSubarrayI();
        assertEquals(expected, solution.findMaxAverage(nums, k), 0.00001d);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,12,-5,-6,50,3}, 4, 12.75000),
                Arguments.of(new int[] {5}, 1, 5.00000),
                Arguments.of(new int[] {-1}, 1, -1.00000),
                Arguments.of(new int[] {9,7,3,5,6,2,0,8,1,9}, 6, 5.33333)
        );
    }

}
