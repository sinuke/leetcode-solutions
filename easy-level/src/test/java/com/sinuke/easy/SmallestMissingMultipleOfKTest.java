package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SmallestMissingMultipleOfKTest {

    @ParameterizedTest
    @MethodSource("testData")
    void missingMultiple(int[] nums, int k, int expected) {
        var solution = new SmallestMissingMultipleOfK();
        assertEquals(expected, solution.missingMultiple(nums, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {8,2,3,4,6}, 2, 10),
                Arguments.of(new int[] {1,4,7,10,15}, 5, 5)
        );
    }

}
