package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SmallestStableIndexIITest {

    @ParameterizedTest
    @MethodSource("testData")
    void smallestStableIndexIITest(int[] nums, int k, int expected) {
        var solution = new SmallestStableIndexII();
        assertEquals(expected, solution.smallestStableIndexII(nums, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {5, 0, 1, 4}, 3, 3),
                Arguments.of(new int[] {3, 2, 1}, 1, -1),
                Arguments.of(new int[] {0}, 0, 0)
        );
    }

}
