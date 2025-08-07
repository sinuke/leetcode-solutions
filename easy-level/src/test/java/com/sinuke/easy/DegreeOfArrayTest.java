package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DegreeOfArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findShortestSubArray(int[] nums, int expected) {
        var solution = new DegreeOfArray();
        assertEquals(expected, solution.findShortestSubArray(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,2,2,3,1}, 2),
                Arguments.of(new int[] {1,2,2,3,1,4,2}, 6)
        );
    }

}
