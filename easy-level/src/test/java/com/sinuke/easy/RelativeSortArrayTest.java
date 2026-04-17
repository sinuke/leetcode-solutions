package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class RelativeSortArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void relativeSortArray(int[] arr1, int[] arr2, int[] expected) {
        assertArrayEquals(expected, new RelativeSortArray().relativeSortArray(arr1, arr2));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6}, new int[]{2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19}),
                Arguments.of(new int[]{28, 6, 22, 8, 44, 17}, new int[]{22, 28, 8, 6}, new int[]{22, 28, 8, 6, 17, 44})
        );
    }

}
