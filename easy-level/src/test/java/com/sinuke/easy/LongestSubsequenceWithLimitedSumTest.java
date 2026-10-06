package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class LongestSubsequenceWithLimitedSumTest {

    @ParameterizedTest
    @MethodSource("testData")
    void answerQueries(int[] nums, int[] queries, int[] expected) {
        var solution = new LongestSubsequenceWithLimitedSum();
        assertArrayEquals(expected, solution.answerQueries(nums, queries));
        assertArrayEquals(expected, solution.answerQueries2(nums, queries));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {4,5,2,1}, new int[] {3,10,21}, new int[] {2,3,4}),
                Arguments.of(new int[] {2,3,4,5}, new int[] {1}, new int[] {0})
        );
    }

}
