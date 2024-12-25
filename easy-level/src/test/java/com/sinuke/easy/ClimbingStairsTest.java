package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClimbingStairsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void climbStairs(int input, int expected) {
        var climbingStairs = new ClimbingStairs();

        assertEquals(expected, climbingStairs.climbStairs(input));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(2, 2),
                Arguments.of(3, 3),
                Arguments.of(4, 5),
                Arguments.of(5, 8),
                Arguments.of(6, 13),
                Arguments.of(7, 21),
                Arguments.of(35, 14930352)
        );
    }

}
