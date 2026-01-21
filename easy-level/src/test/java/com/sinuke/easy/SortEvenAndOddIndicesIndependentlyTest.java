package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortEvenAndOddIndicesIndependentlyTest {

    @ParameterizedTest
    @MethodSource("testData")
    void sortEvenOdd(int[] nums, int[] expected) {
        var solution = new SortEvenAndOddIndicesIndependently();
        assertArrayEquals(expected, solution.sortEvenOdd(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {4,1,2,3}, new int[] {2,3,4,1}),
                Arguments.of(new int[] {2,1}, new int[] {2,1})
        );
    }

}
