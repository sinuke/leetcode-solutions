package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountDominantIndicesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void dominantIndices(int[] nums, int expected) {
        var solution = new CountDominantIndices();
        assertEquals(expected, solution.dominantIndices(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {5,4,3}, 2),
                Arguments.of(new int[] {4,1,2}, 1)
        );
    }

}
