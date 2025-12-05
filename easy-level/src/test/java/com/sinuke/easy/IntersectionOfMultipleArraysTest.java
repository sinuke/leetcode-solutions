package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IntersectionOfMultipleArraysTest {

    @ParameterizedTest
    @MethodSource("testData")
    void intersection(int[][] nums, List<Integer> expected) {
        var solution = new IntersectionOfMultipleArrays();
        assertEquals(expected, solution.intersection(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{3,1,2,4,5},{1,2,3,4},{3,4,5,6}}, List.of(3,4)),
                Arguments.of(new int[][] {{1,2,3},{4,5,6}}, List.of())
        );
    }

}
