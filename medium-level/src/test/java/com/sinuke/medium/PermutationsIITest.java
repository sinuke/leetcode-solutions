package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PermutationsIITest {

    @ParameterizedTest
    @MethodSource("testData")
    void permuteUnique(int[] nums, List<List<Integer>> expected) {
        var solution = new PermutationsII();
        assertEquals(expected, solution.permuteUnique(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,1,2}, List.of(List.of(1,1,2), List.of(1,2,1), List.of(2,1,1))),
                Arguments.of(new int[] {1,2,3}, List.of(List.of(1,2,3), List.of(1,3,2), List.of(2,1,3), List.of(2,3,1), List.of(3,1,2), List.of(3,2,1)))
        );
    }

}
