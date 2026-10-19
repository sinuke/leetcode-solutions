package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdjacentIncreasingSubarraysDetectionITest {

    @ParameterizedTest
    @MethodSource("testData")
    void hasIncreasingSubarrays(List<Integer> nums, int k, boolean expected) {
        var solution = new AdjacentIncreasingSubarraysDetectionI();
        assertEquals(expected, solution.hasIncreasingSubarrays(nums, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(List.of(2, 5, 7, 8, 9, 2, 3, 4, 3, 1), 3, true),
                Arguments.of(List.of(1, 2, 3, 4, 4, 4, 4, 5, 6, 7), 5, false),
                Arguments.of(List.of(11,17,-16,-18,-6,12,6,8), 2, true)
        );
    }

}
