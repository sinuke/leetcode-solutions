package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindPivotIndexTest {

    @ParameterizedTest
    @MethodSource("testData")
    void pivotIndex(int[] nums, int expected) {
        var solution = new FindPivotIndex();
        assertEquals(expected, solution.pivotIndex(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,7,3,6,5,6}, 3),
                Arguments.of(new int[] {1,2,3}, -1),
                Arguments.of(new int[] {2,1,-1}, 0)
        );
    }

}
