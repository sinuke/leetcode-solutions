package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class KthSmallestPrimeFractionTest {

    @ParameterizedTest
    @MethodSource("testData")
    void kthSmallestPrimeFraction(int[] arr, int k, int[] expected) {
        assertArrayEquals(expected, new KthSmallestPrimeFraction().kthSmallestPrimeFraction(arr, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 5}, 3, new int[]{2, 5}),
                Arguments.of(new int[]{1, 7}, 1, new int[]{1, 7})
        );
    }

}
