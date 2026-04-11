package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumDistanceBetweenThreeEqualElementsIITest {

    @ParameterizedTest
    @MethodSource("testData")
    void minimumDistance(int[] nums, int expected) {
        var solution = new MinimumDistanceBetweenThreeEqualElementsII();
        assertEquals(expected, solution.minimumDistance(nums));
        assertEquals(expected, solution.minimumDistance2(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 1, 1, 3}, 6),
                Arguments.of(new int[]{1, 1, 2, 3, 2, 1, 2}, 8),
                Arguments.of(new int[]{1}, -1)
        );
    }

}
