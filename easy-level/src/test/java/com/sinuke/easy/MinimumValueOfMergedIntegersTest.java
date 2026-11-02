package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumValueOfMergedIntegersTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minMergedInteger(int[] nums, int expected) {
        var solution = new MinimumValueOfMergedIntegers();
        assertEquals(expected, solution.minMergedInteger(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {23, 55, 42, 21}, 2355),
                Arguments.of(new int[] {34, 7, 11, 11}, 347),
                Arguments.of(new int[] {9, 20}, 920)
        );
    }

}
