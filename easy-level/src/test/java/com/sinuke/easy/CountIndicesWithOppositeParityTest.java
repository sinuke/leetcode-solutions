package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class CountIndicesWithOppositeParityTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countOppositeParity(int[] nums, int[] expected) {
        assertArrayEquals(expected, new CountIndicesWithOppositeParity().countOppositeParity(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4}, new int[]{2, 1, 1, 0}),
                Arguments.of(new int[]{1}, new int[]{0})
        );
    }

}
