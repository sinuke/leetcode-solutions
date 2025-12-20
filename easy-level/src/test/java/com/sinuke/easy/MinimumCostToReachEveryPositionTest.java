package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MinimumCostToReachEveryPositionTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minCosts(int[] cost, int[] expected) {
        var solution = new MinimumCostToReachEveryPosition();
        assertArrayEquals(expected, solution.minCosts(cost));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {5,3,4,1,3,2}, new int[] {5,3,3,1,1,1}),
                Arguments.of(new int[] {1,2,4,6,7}, new int[] {1,1,1,1,1})
        );
    }

}
