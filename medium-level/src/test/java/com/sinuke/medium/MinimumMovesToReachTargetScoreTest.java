package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumMovesToReachTargetScoreTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minMoves(int target, int maxDoubles, int expected) {
        var solution = new MinimumMovesToReachTargetScore();
        assertEquals(expected, solution.minMoves(target, maxDoubles));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(5, 0, 4),
                Arguments.of(19, 2, 7),
                Arguments.of(10, 4, 4)
        );
    }

}
