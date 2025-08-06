package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DistributeCandiesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void distributeCandies(int[] candyType, int expected) {
        var solution = new DistributeCandies();
        assertEquals(expected, solution.distributeCandies(candyType));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,1,2,2,3,3}, 3),
                Arguments.of(new int[] {1,1,2,3}, 2),
                Arguments.of(new int[] {6,6,6,6}, 1)
        );
    }

}
