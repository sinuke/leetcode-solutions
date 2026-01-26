package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FormSmallestNumberFromTwoDigitArraysTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minNumber(int[] nums1, int[] nums2, int expected) {
        var solution = new FormSmallestNumberFromTwoDigitArrays();
        assertEquals(expected, solution.minNumber(nums1, nums2));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {4,1,3}, new int[] {5,7}, 15),
                Arguments.of(new int[] {3,5,2,6}, new int[] {3,1,7}, 3)
        );
    }

}
