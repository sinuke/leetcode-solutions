package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SmallestAbsentPositiveGreaterThanAverageTest {

    @ParameterizedTest
    @MethodSource("testData")
    void smallestAbsent(int[] nums, int expected) {
        var solution = new SmallestAbsentPositiveGreaterThanAverage();
        assertEquals(expected, solution.smallestAbsent(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {3,5}, 6),
                Arguments.of(new int[] {-1,1,2}, 3),
                Arguments.of(new int[] {4,-1}, 2)
        );
    }

}
