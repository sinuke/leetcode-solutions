package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumDifferenceBetweenAdjacentElementsInCircularArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maxAdjacentDistance(int[] nums, int expected) {
        var solution = new MaximumDifferenceBetweenAdjacentElementsInCircularArray();
        assertEquals(expected, solution.maxAdjacentDistance(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,2,4}, 3),
                Arguments.of(new int[] {-5,-10,-5}, 5)
        );
    }

}
