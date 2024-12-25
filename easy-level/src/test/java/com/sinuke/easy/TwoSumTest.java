package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TwoSumTest {

    @ParameterizedTest
    @MethodSource("testData")
    void twoSum(int[] input, int target, int[] expected) {
        var twoSum = new TwoSum();
        assertArrayEquals(expected, twoSum.twoSum(input, target));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {2, 7, 11, 15}, 9, new int[] {1, 0}),
                Arguments.of(new int[] {3,2,4}, 6, new int[] {2, 1}),
                Arguments.of(new int[] {3, 3}, 6, new int[] {1, 0})
        );
    }

}
