package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FindLosersOfCircularGameTest {

    @ParameterizedTest
    @MethodSource("testData")
    void circularGameLosers(int n, int k, int[] expected) {
        var solution = new FindLosersOfCircularGame();
        assertArrayEquals(expected, solution.circularGameLosers(n, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(5, 2, new int[] {4,5}),
                Arguments.of(4, 4, new int[] {2,3,4})
        );
    }

}
