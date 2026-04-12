package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SmallestRangeITest {

    @ParameterizedTest
    @MethodSource("testData")
    void smallestRangeI(int[] nums, int k, int expected) {
        var solution = new SmallestRangeI();
        assertEquals(expected, solution.smallestRangeI(nums, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{1}, 0, 0),
                Arguments.of(new int[]{0, 10}, 2, 6),
                Arguments.of(new int[]{1, 3, 6}, 3, 0)
        );
    }

}
