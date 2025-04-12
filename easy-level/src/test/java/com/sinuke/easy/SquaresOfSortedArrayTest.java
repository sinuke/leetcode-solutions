package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SquaresOfSortedArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void sortedSquares(int[] nums, int[] expected) {
        var solution = new SquaresOfSortedArray();
        assertArrayEquals(expected, solution.sortedSquares(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {-4,-1,0,3,10}, new int[] {0,1,9,16,100}),
                Arguments.of(new int[] {-7,-3,2,3,11}, new int[] {4,9,9,49,121}),
                Arguments.of(new int[] {-1}, new int[] {1}),
                Arguments.of(new int[] {-10000,-9999,-7,-5,0,0,10000}, new int[] {0,0,25,49,99980001,100000000,100000000})
        );
    }

}
