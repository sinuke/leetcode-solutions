package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindKOrOfArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findKOr(int[] nums, int k, int expected) {
        assertEquals(expected, new FindKOrOfArray().findKOr(nums, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{7, 12, 9, 8, 9, 15}, 4, 9),
                Arguments.of(new int[]{2, 12, 1, 11, 4, 5}, 6, 0),
                Arguments.of(new int[]{10, 8, 5, 9, 11, 6, 8}, 1, 15)
        );
    }

}
