package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EvenNumberOfKnightMovesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void canReach(int[] start, int[] target, boolean expected) {
        assertEquals(expected, new EvenNumberOfKnightMoves().canReach(start, target));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1, 1}, new int[] {2, 2}, true),
                Arguments.of(new int[] {4, 5}, new int[] {6, 6}, false)
        );
    }

}
