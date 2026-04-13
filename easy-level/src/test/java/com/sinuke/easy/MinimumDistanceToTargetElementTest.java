package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumDistanceToTargetElementTest {

    @ParameterizedTest
    @MethodSource("testData")
    void getMinDistance(int[] nums, int target, int start, int expected) {
        assertEquals(expected, new MinimumDistanceToTargetElement().getMinDistance(nums, target, start));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1, 2, 3, 4, 5}, 5, 3, 1),
                Arguments.of(new int[] {1}, 1, 0, 0),
                Arguments.of(new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 1, 0, 0)
        );
    }

}
