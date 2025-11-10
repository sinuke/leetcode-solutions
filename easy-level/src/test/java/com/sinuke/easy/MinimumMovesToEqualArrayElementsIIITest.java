package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumMovesToEqualArrayElementsIIITest {

    @ParameterizedTest
    @MethodSource("testData")
    void minMoves(int[] nums, int expected) {
        var solution = new MinimumMovesToEqualArrayElementsIII();
        assertEquals(expected, solution.minMoves(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {2, 1, 3}, 3),
                Arguments.of(new int[] {4,4,5}, 2)
        );
    }

}
