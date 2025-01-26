package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumOfVariableLengthSubarraysTest {

    @ParameterizedTest
    @MethodSource("testData")
    void subarraySum(int[] nums, int expected) {
        var sumOfVariableLengthSubarrays = new SumOfVariableLengthSubarrays();
        assertEquals(expected, sumOfVariableLengthSubarrays.subarraySum(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {2,3,1}, 11),
                Arguments.of(new int[] {3,1,1,2}, 13)
        );
    }

}
