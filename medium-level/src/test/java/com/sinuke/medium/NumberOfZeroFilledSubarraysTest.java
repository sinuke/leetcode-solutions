package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfZeroFilledSubarraysTest {

    @ParameterizedTest
    @MethodSource("testData")
    void zeroFilledSubarray(int[] nums, int expected) {
        var solution = new NumberOfZeroFilledSubarrays();
        assertEquals(expected, solution.zeroFilledSubarray(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,3,0,0,2,0,0,4}, 6),
                Arguments.of(new int[] {0,0,0,2,0,0}, 9),
                Arguments.of(new int[] {2,10,2019}, 0)
        );
    }

}
