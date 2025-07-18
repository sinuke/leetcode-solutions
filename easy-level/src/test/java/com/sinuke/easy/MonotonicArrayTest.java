package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MonotonicArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isMonotonic(int[] nums, boolean expected) {
        var solution = new MonotonicArray();
        assertEquals(expected, solution.isMonotonic(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,2,2,3}, true),
                Arguments.of(new int[] {6,5,4,4}, true),
                Arguments.of(new int[] {1,3,2}, false)
        );
    }

}
