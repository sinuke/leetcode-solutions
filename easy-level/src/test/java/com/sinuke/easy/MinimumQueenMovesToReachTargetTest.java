package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumQueenMovesToReachTargetTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minQueenMoves(int[] source, int[] target, int expected) {
        var solution = new MinimumQueenMovesToReachTarget();
        assertEquals(expected, solution.minQueenMoves(source, target));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{8, 1}, new int[]{1, 8}, 1),
                Arguments.of(new int[]{4, 2}, new int[]{1, 3}, 2),
                Arguments.of(new int[]{1, 1}, new int[]{1, 1}, 0)
        );
    }

}
