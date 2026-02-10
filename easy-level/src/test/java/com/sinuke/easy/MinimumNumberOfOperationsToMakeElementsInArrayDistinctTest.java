package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumNumberOfOperationsToMakeElementsInArrayDistinctTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minimumOperations(int[] nums, int expected) {
        var solution = new MinimumNumberOfOperationsToMakeElementsInArrayDistinct();
        assertEquals(expected, solution.minimumOperations(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,2,3,4,2,3,3,5,7}, 2),
                Arguments.of(new int[] {4,5,6,4,4}, 2),
                Arguments.of(new int[] {6,7,8,9}, 0)
        );
    }

}
