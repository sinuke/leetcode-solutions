package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class RearrangeArrayElementsBySignTest {

    @ParameterizedTest
    @MethodSource("testData")
    void rearrangeArray(int[] nums, int[] expected) {
        var solution = new RearrangeArrayElementsBySign();
        assertArrayEquals(expected, solution.rearrangeArray(nums));
        assertArrayEquals(expected, solution.rearrangeArray2(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{3, 1, -2, -5, 2, -4}, new int[]{3, -2, 1, -5, 2, -4}),
                Arguments.of(new int[]{-1, 1}, new int[]{1, -1})
        );
    }

}
