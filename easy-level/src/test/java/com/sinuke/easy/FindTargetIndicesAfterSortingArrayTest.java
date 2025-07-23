package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindTargetIndicesAfterSortingArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void targetIndices(int[] nums, int target, List<Integer> expected) {
        var solution = new FindTargetIndicesAfterSortingArray();
        assertEquals(expected, solution.targetIndices(nums, target));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,2,5,2,3}, 2, List.of(1,2)),
                Arguments.of(new int[] {1,2,5,2,3}, 3, List.of(3)),
                Arguments.of(new int[] {1,2,5,2,3}, 5, List.of(4))
        );
    }

}
