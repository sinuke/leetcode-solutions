package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DistributeElementsIntoTwoArraysITest {

    @ParameterizedTest
    @MethodSource("testData")
    void resultArray(int[] nums, int[] expected) {
        var solution = new DistributeElementsIntoTwoArraysI();
        assertArrayEquals(expected, solution.resultArray(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {2,1,3}, new int[] {2,3,1}),
                Arguments.of(new int[] {5,4,3,8}, new int[] {5,3,4,8})
        );
    }

}
