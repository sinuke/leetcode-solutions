package com.sinuke;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class IntersectionOfTwoArraysTest {

    @ParameterizedTest
    @MethodSource("testData")
    void intersection(int[] nums1, int[] nums2, int[] expected) {
        // given
        var intersectionOfTwoArrays = new IntersectionOfTwoArrays();
        Arrays.sort(expected);

        // when
        var actual1 = intersectionOfTwoArrays.intersection(nums1, nums2);
        Arrays.sort(actual1);

        var actual2 = intersectionOfTwoArrays.intersection2(nums1, nums2);
        Arrays.sort(actual2);

        // then
        assertArrayEquals(expected, actual1);
        assertArrayEquals(expected, actual2);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1, 2, 2, 1}, new int[] {2, 2}, new int[] {2}),
                Arguments.of(new int[] {4, 9, 5}, new int[] {9, 4, 9, 8, 4}, new int[] {4, 9})
        );
    }

}
