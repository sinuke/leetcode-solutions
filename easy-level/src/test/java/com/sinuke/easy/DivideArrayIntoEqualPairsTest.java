package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DivideArrayIntoEqualPairsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void divideArray(int[] nums, boolean expected) {
        var solution = new DivideArrayIntoEqualPairs();
        assertEquals(expected, solution.divideArray(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {3,2,3,2,2,2}, true),
                Arguments.of(new int[] {1,2,3,4}, false)
        );
    }

}
