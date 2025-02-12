package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MinimumNumberGameTest {

    @ParameterizedTest
    @MethodSource("testData")
    void numberGame(int[] nums, int[] expected) {
        var solution = new MinimumNumberGame();
        assertArrayEquals(expected, solution.numberGame(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {5,4,2,3}, new int[] {3,2,5,4}),
                Arguments.of(new int[] {2,5}, new int[] {5, 2})
        );
    }

}
