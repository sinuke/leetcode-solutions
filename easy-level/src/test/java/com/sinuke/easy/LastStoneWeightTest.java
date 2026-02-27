package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LastStoneWeightTest {

    @ParameterizedTest
    @MethodSource("testData")
    void lastStoneWeight(int[] stones, int expected) {
        var solution = new LastStoneWeight();
        assertEquals(expected, solution.lastStoneWeight(stones));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {2,7,4,1,8,1}, 1),
                Arguments.of(new int[] {1}, 1)
        );
    }

}
