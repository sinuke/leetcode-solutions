package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumAbsoluteDifferenceTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minimumAbsDifference(int[] arr, List<List<Integer>> expected) {
        var solution = new MinimumAbsoluteDifference();
        assertEquals(expected, solution.minimumAbsDifference(arr));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {4,2,1,3}, List.of(List.of(1,2), List.of(2,3), List.of(3,4))),
                Arguments.of(new int[] {1,3,6,10,15}, List.of(List.of(1,3))),
                Arguments.of(new int[] {3,8,-10,23,19,-4,-14,27}, List.of(List.of(-14,-10), List.of(19,23), List.of(23,27)))
        );
    }

}
