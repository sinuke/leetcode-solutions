package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidBoomerangTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isBoomerang(int[][] points, boolean expected) {
        var solution = new ValidBoomerang();
        assertEquals(expected, solution.isBoomerang(points));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{1,1},{2,3},{3,2}}, true),
                Arguments.of(new int[][] {{1,1},{2,2},{3,3}}, false)
        );
    }

}
