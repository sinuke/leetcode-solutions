package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class RunningSumOf1dArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void runningSum(int[] nums, int[] expected) {
        var runningSum = new RunningSumOf1dArray();
        assertArrayEquals(expected, runningSum.runningSum(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,2,3,4}, new int[] {1,3,6,10}),
                Arguments.of(new int[] {1,1,1,1,1}, new int[] {1,2,3,4,5}),
                Arguments.of(new int[] {3,1,2,10,1}, new int[] {3,4,6,16,17})
        );
    }

}
