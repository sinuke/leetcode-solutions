package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AbsoluteDifferenceBetweenMaximumAndMinimumKElementsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void absDifference(int[] nums, int k, int expected) {
        var solution = new AbsoluteDifferenceBetweenMaximumAndMinimumKElements();
        assertEquals(expected, solution.absDifference(nums, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {5,2,2,4}, 2, 5),
                Arguments.of(new int[] {100}, 1, 0)
        );
    }

}
