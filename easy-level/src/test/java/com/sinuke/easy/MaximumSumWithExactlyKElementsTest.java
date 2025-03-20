package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumSumWithExactlyKElementsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maximizeSum(int[] nums, int k, int expected) {
        var solution = new MaximumSumWithExactlyKElements();
        assertEquals(expected, solution.maximizeSum(nums, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,2,3,4,5}, 3, 18),
                Arguments.of(new int[] {5,5,5}, 2, 11)
        );
    }

}
