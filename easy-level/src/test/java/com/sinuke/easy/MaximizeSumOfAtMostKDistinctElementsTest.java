package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MaximizeSumOfAtMostKDistinctElementsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maxKDistinct(int[] nums, int k, int[] expected) {
        var solution = new MaximizeSumOfAtMostKDistinctElements();
        assertArrayEquals(expected, solution.maxKDistinct(nums, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {84,93,100,77,90}, 3, new int[] {100,93,90}),
                Arguments.of(new int[] {84,93,100,77,93}, 3, new int[] {100,93,84}),
                Arguments.of(new int[] {1,1,1,2,2,2}, 6, new int[] {2, 1})
        );
    }

}
