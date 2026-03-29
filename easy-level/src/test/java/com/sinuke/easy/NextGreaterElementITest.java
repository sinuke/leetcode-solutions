package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class NextGreaterElementITest {

    @ParameterizedTest
    @MethodSource("testData")
    void nextGreaterElement(int[] nums1, int[] nums2, int[] expected) {
        var solution = new NextGreaterElementI();
        assertArrayEquals(expected, solution.nextGreaterElement(nums1, nums2));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2}, new int[]{-1, 3, -1}),
                Arguments.of(new int[]{2, 4}, new int[]{1, 2, 3, 4}, new int[]{3, -1})
        );
    }
}
