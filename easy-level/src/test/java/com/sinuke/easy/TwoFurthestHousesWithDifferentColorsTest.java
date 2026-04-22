package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TwoFurthestHousesWithDifferentColorsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maxDistance(int[] colors, int expected) {
        var solution = new TwoFurthestHousesWithDifferentColors();
        assertEquals(expected, solution.maxDistance(colors));
        assertEquals(expected, solution.maxDistance2(colors));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1, 1, 1, 6, 1, 1, 1}, 3),
                Arguments.of(new int[] {1, 8, 3, 8, 3}, 4),
                Arguments.of(new int[] {0, 1}, 1)
        );
    }

}
