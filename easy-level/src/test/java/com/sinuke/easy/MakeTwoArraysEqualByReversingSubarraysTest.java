package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MakeTwoArraysEqualByReversingSubarraysTest {

    @ParameterizedTest
    @MethodSource("testData")
    void canBeEqual(int[] target, int[] arr, boolean expected) {
        assertEquals(expected, new MakeTwoArraysEqualByReversingSubarrays().canBeEqual(target, arr));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3}, true),
                Arguments.of(new int[]{7}, new int[]{7}, true),
                Arguments.of(new int[]{3, 7, 9}, new int[]{3, 7, 11}, false)
        );
    }

}
