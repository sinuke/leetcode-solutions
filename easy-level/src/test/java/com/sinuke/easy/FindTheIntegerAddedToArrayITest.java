package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindTheIntegerAddedToArrayITest {

    @ParameterizedTest
    @MethodSource("testData")
    void addedInteger(int[] nums1, int[] nums2, int expected) {
        var solution = new FindTheIntegerAddedToArrayI();
        assertEquals(expected, solution.addedInteger(nums1, nums2));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {2,6,4}, new int[] {9,7,5}, 3),
                Arguments.of(new int[] {10}, new int[] {5}, -5),
                Arguments.of(new int[] {1,1,1,1}, new int[] {1,1,1,1}, 0)
        );
    }

}