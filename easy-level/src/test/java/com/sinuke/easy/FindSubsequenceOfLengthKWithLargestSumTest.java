package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FindSubsequenceOfLengthKWithLargestSumTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maxSubsequence(int[] nums, int k, int[] expected) {
        var solution = new FindSubsequenceOfLengthKWithLargestSum();
        assertArrayEquals(expected, solution.maxSubsequence(nums, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {2,1,3,3}, 2, new int[] {3,3}),
                Arguments.of(new int[] {-1,-2,3,4}, 3, new int[] {-1,3,4}),
                Arguments.of(new int[] {3,4,3,3}, 2, new int[] {3,4})
        );
    }

}
