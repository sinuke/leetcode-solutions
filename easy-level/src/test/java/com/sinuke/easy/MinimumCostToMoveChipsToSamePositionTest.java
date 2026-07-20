package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumCostToMoveChipsToSamePositionTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minCostToMoveChips(int[] position, int expected) {
        assertEquals(expected, new MinimumCostToMoveChipsToSamePosition().minCostToMoveChips(position));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, 1),
                Arguments.of(new int[]{2, 2, 2, 3, 3}, 2),
                Arguments.of(new int[]{1, 1000000000}, 1)
        );
    }
}
