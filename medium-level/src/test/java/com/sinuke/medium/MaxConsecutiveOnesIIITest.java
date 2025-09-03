package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxConsecutiveOnesIIITest {

    @ParameterizedTest
    @MethodSource("testData")
    void longestOnes(int[] nums, int k, int expected) {
        var solution = new MaxConsecutiveOnesIII();
        assertEquals(expected, solution.longestOnes(nums, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,1,1,0,0,0,1,1,1,1,0}, 2, 6),
                Arguments.of(new int[] {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3, 10),
                Arguments.of(new int[] {0,1,1}, 0, 2)
        );
    }

}
