package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ApplyOperationsToArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void applyOperations(int[] nums, int[] expected) {
        var solution = new ApplyOperationsToArray();
        assertArrayEquals(expected, solution.applyOperations(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,2,2,1,1,0}, new int[] {1,4,2,0,0,0}),
                Arguments.of(new int[] {0,1}, new int[] {1,0})
        );
    }

}
