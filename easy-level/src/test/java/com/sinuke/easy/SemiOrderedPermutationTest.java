package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SemiOrderedPermutationTest {

    @ParameterizedTest
    @MethodSource("testData")
    void semiOrderedPermutation(int[] nums, int expected) {
        assertEquals(expected, new SemiOrderedPermutation().semiOrderedPermutation(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{2, 1, 4, 3}, 2),
                Arguments.of(new int[]{2, 4, 1, 3}, 3),
                Arguments.of(new int[]{1, 3, 4, 2, 5}, 0)
        );
    }
}
