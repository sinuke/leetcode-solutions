package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindTheDifferenceOfTwoArraysTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findDifference(int[] nums1, int[] nums2, List<Set<Integer>> expected) {
        var solution = new FindTheDifferenceOfTwoArrays();
        var actual = solution.findDifference(nums1, nums2);
        assertEquals(expected.getFirst(), new HashSet<>(actual.getFirst()));
        assertEquals(expected.getLast(), new HashSet<>(actual.getLast()));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,2,3}, new int[] {2,4,6}, List.of(Set.of(1,3), Set.of(4,6))),
                Arguments.of(new int[] {1,2,3,3}, new int[] {1,1,2,2}, List.of(Set.of(3), Set.of()))
        );
    }

}
