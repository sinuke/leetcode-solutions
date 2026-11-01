package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumMovesToEqualArrayElementsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minMoves(int[] nums, int expected) {
        var solution = new MinimumMovesToEqualArrayElements();
        assertEquals(expected, solution.minMoves(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, 3),
                Arguments.of(new int[]{1, 1, 1}, 0)
        );
    }

}
