package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumSumOfMountainTripletsITest {

    @ParameterizedTest
    @MethodSource("testData")
    void minimumSum(int[] nums, int expected) {
        var solution = new MinimumSumOfMountainTripletsI();
        assertEquals(expected, solution.minimumSum(nums));
        assertEquals(expected, solution.minimumSum2(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {8,6,1,5,3}, 9),
                Arguments.of(new int[] {5,4,8,7,10,2}, 13),
                Arguments.of(new int[] {6,5,4,3,4,5}, -1)
        );
    }

}
