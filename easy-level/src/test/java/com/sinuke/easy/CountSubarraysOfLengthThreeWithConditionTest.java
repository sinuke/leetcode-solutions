package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountSubarraysOfLengthThreeWithConditionTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countSubarrays(int[] nums, int expected) {
        var solution = new CountSubarraysOfLengthThreeWithCondition();
        assertEquals(expected, solution.countSubarrays(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,2,1,4,1}, 1),
                Arguments.of(new int[] {1,1,1}, 0)
        );
    }

}
