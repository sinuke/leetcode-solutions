package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FindXSumOfAllKLongSubarraysITest {

    @ParameterizedTest
    @MethodSource("testData")
    void findXSum(int[] nums, int k, int x, int[] expected) {
        var solution = new FindXSumOfAllKLongSubarraysI();
        assertArrayEquals(expected, solution.findXSum(nums, k, x));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,1,2,2,3,4,2,3}, 6, 2, new int[] {6,10,12}),
                Arguments.of(new int[] {3,8,7,8,7,5}, 2, 2, new int[] {11,15,15,15,12})
        );
    }

}
