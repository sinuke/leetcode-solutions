package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FairCandySwapTest {

    @ParameterizedTest
    @MethodSource("testData")
    void fairCandySwap(int[] aliceSizes, int[] bobSizes, int[] expected) {
        var solution = new FairCandySwap();
        assertArrayEquals(expected, solution.fairCandySwap(aliceSizes, bobSizes));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,1}, new int[] {2,2}, new int[] {1,2}),
                Arguments.of(new int[] {1,2}, new int[] {2,3}, new int[] {1,2}),
                Arguments.of(new int[] {2}, new int[] {1,3}, new int[] {2,3})
        );
    }

}
