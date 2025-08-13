package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindMinimumInRotatedSortedArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findMin(int[] nums, int expected) {
        var solution = new FindMinimumInRotatedSortedArray();
        assertEquals(expected, solution.findMin(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {3,4,5,1,2}, 1),
                Arguments.of(new int[] {4,5,6,7,0,1,2}, 0),
                Arguments.of(new int[] {11,13,15,17}, 11)
        );
    }

}
