package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfWaysToSplitArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void waysToSplitArray(int[] nums, int expected) {
        var number = new NumberOfWaysToSplitArray();
        assertEquals(expected, number.waysToSplitArray(nums));
        assertEquals(expected, number.waysToSplitArray2(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {10,4,-8,7}, 2),
                Arguments.of(new int[] {2,3,1,0}, 2),
                Arguments.of(new int[] {0,-1,-2,5,2}, 1),
                Arguments.of(new int[] {0,-1,-2,-3,-4}, 3)
        );
    }

}