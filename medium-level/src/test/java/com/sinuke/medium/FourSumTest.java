package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FourSumTest {

    @ParameterizedTest
    @MethodSource("testData")
    void fourSum(int[] nums, int target, List<List<Integer>> expected) {
        var solution = new FourSum();
        var actual = solution.fourSum(nums, target);

        var expectedSet = new HashSet<Set<Integer>>();
        expected.forEach(n -> expectedSet.add(new HashSet<>(n)));

        assertEquals(expected.size(), actual.size());
        actual.forEach(a -> assertTrue(expectedSet.contains(new HashSet<>(a))));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,0,-1,0,-2,2}, 0, List.of(List.of(-2,-1,1,2), List.of(-2,0,0,2), List.of(-1,0,0,1))),
                Arguments.of(new int[] {2,2,2,2,2}, 8, List.of(List.of(2, 2, 2, 2)))
        );
    }

}
