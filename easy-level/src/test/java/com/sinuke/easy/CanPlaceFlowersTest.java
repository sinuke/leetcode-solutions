package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CanPlaceFlowersTest {

    @ParameterizedTest
    @MethodSource("testData")
    void canPlaceFlowers(int[] flowerbed, int n, boolean expected) {
        var solution = new CanPlaceFlowers();
        assertEquals(expected, solution.canPlaceFlowers(flowerbed, n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{1, 0, 0, 0, 1}, 1, true),
                Arguments.of(new int[]{1, 0, 0, 0, 1}, 2, false)
        );
    }
}
