package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumSwapsToMoveZerosToEndTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minimumSwaps(int[] nums, int expected) {
        assertEquals(expected, new MinimumSwapsToMoveZerosToEnd().minimumSwaps(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {0, 1, 0, 3, 12}, 2),
                Arguments.of(new int[] {0, 1, 0, 2}, 1),
                Arguments.of(new int[] {1, 2, 0}, 0),
                Arguments.of(new int[] {0, 65, 0}, 1),
                Arguments.of(new int[] {0, 0}, 0)
        );
    }

}
