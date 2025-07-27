package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountHillsAndValleysInArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countHillValley(int[] nums, int expected) {
        var solution = new CountHillsAndValleysInArray();
        assertEquals(expected, solution.countHillValley(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {2,4,1,1,6,5}, 3),
                Arguments.of(new int[] {6,6,5,5,4,1}, 0)
        );
    }

}
