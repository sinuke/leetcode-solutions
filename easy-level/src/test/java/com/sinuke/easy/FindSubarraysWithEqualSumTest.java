package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindSubarraysWithEqualSumTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findSubarrays(int[] nums, boolean expected) {
        var solution = new FindSubarraysWithEqualSum();
        assertEquals(expected, solution.findSubarrays(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {4,2,4}, true),
                Arguments.of(new int[] {1,2,3,4,5}, false),
                Arguments.of(new int[] {0,0,0}, true)
        );
    }

}
