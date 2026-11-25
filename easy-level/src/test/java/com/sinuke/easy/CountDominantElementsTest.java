package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountDominantElementsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countDominantElements(int[] nums, int expected) {
        var solution = new CountDominantElements();
        assertEquals(expected, solution.countDominantElements(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1, 10, 2}, 1),
                Arguments.of(new int[] {6, 4, 2}, 2),
                Arguments.of(new int[] {7}, 1)
        );
    }

}
