package com.sinuke;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeSortedArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void merge(int[] nums1, int m, int[] nums2, int n, int[] expected) {
        var mergeSortedArray = new MergeSortedArray();

        mergeSortedArray.merge(nums1, m, nums2, n);

        assertArrayEquals(expected, nums1);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1, 2, 3, 0, 0, 0}, 3, new int[] {2, 5, 6}, 3, new int[] {1, 2, 2, 3, 5, 6}),
                Arguments.of(new int[] {1}, 1, new int[] {}, 0, new int[] {1}),
                Arguments.of(new int[] {0}, 0, new int[] {1}, 1, new int[] {1}),
                Arguments.of(new int[] {4, 0, 0, 0, 0, 0}, 1, new int[] {1, 2, 3, 5, 6}, 5, new int[] {1, 2, 3, 4, 5, 6}),
                Arguments.of(new int[] {30, 31, 0, 0, 0}, 2, new int[] {2, 4, 5}, 3, new int[] {2, 4, 5, 30, 31}),
                Arguments.of(new int[] {1, 2, 50, 51, 0, 0}, 4, new int[] {4, 5}, 2, new int[] {1, 2, 4, 5, 50, 51}),
                Arguments.of(new int[] {2, 3, 50, 51, 0, 0}, 4, new int[] {1, 49}, 2, new int[] {1, 2, 3, 49, 50, 51}),
                Arguments.of(new int[] {50, 60, 61, 0}, 3, new int[] {1}, 1, new int[] {1, 50, 60, 61})
        );
    }

}
