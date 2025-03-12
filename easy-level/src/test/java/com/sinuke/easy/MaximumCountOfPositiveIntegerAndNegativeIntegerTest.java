package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumCountOfPositiveIntegerAndNegativeIntegerTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maximumCount(int[] nums, int expected) {
        var solution = new MaximumCountOfPositiveIntegerAndNegativeInteger();
        assertEquals(expected, solution.maximumCount(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {-2,-1,-1,1,2,3}, 3),
                Arguments.of(new int[] {-3,-2,-1,0,0,1,2}, 3),
                Arguments.of(new int[] {5,20,66,1314}, 4)
        );
    }

}