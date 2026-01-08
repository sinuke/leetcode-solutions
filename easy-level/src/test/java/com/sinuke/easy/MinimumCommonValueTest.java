package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumCommonValueTest {

    @ParameterizedTest
    @MethodSource("testData")
    void getCommon(int[] nums1, int[] nums2, int expected) {
        var solution = new MinimumCommonValue();
        assertEquals(expected, solution.getCommon(nums1, nums2));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,2,3}, new int[] {2,4}, 2),
                Arguments.of(new int[] {1,2,3,6}, new int[] {2,3,4,5}, 2)
        );
    }

}
