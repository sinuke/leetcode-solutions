package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TwoOutOfThreeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void twoOutOfThree(int[] nums1, int[] nums2, int[] nums3, List<Integer> expected) {
        var solution = new TwoOutOfThree();
        assertEquals(new HashSet<>(expected), new HashSet<>(solution.twoOutOfThree(nums1, nums2, nums3)));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,1,3,2}, new int[] {2,3}, new int[] {3}, List.of(3,2)),
                Arguments.of(new int[] {3,1}, new int[] {2,3}, new int[] {1,2}, List.of(2,3,1)),
                Arguments.of(new int[] {1,2,2}, new int[] {4,3,3}, new int[] {5}, List.of())
        );
    }

}
