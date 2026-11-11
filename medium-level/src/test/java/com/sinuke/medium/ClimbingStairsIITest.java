package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClimbingStairsIITest {

    @ParameterizedTest
    @MethodSource("testData")
    void climbStairs(int n, int[] costs, int expected) {
        var solution = new ClimbingStairsII();
        assertEquals(expected, solution.climbStairs(n, costs));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(4, new int[] {1, 2, 3, 4}, 13),
                Arguments.of(4, new int[] {5, 1, 6, 2}, 11),
                Arguments.of(3, new int[] {9, 8, 3}, 12)
        );
    }

}
