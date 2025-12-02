package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountElementsWithStrictlySmallerAndGreaterElementsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countElements(int[] nums, int expected) {
        var solution = new CountElementsWithStrictlySmallerAndGreaterElements();
        assertEquals(expected, solution.countElements(nums));
        assertEquals(expected, solution.countElements2(nums));
        assertEquals(expected, solution.countElements3(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {11,7,2,15}, 2),
                Arguments.of(new int[] {-3,3,3,90}, 2),
                Arguments.of(new int[] {723,723,-423,723,-647,532,723,723,212,-391,723}, 4),
                Arguments.of(new int[] {1}, 0)
        );
    }

}
