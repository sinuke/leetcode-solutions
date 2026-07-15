package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumSubsequenceInNonIncreasingOrderTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minSubsequence(int[] nums, List<Integer> expected) {
        assertEquals(expected, new MinimumSubsequenceInNonIncreasingOrder().minSubsequence(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{4, 3, 10, 9, 8}, List.of(10, 9)),
                Arguments.of(new int[]{4, 4, 7, 6, 7}, List.of(7, 7, 6))
        );
    }

}
