package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumMovesToEqualArrayElementsIITest {

    @ParameterizedTest
    @MethodSource("testData")
    void minMoves2(int[] nums, int expected) {
        var solution = new MinimumMovesToEqualArrayElementsII();
        assertEquals(expected, solution.minMoves2(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1, 2, 3}, 2),
                Arguments.of(new int[] {1, 10, 2, 9}, 16)
        );
    }

}
