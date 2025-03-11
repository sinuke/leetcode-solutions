package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumProductDifferenceBetweenTwoPairsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maxProductDifference(int[] nums, int expected) {
        var solution = new MaximumProductDifferenceBetweenTwoPairs();
        assertEquals(expected, solution.maxProductDifference(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {5,6,2,7,4}, 34),
                Arguments.of(new int[] {4,2,5,9,7,4,8}, 64)
        );
    }

}
