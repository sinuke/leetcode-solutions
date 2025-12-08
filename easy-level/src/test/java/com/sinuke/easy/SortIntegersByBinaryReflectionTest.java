package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortIntegersByBinaryReflectionTest {

    @ParameterizedTest
    @MethodSource("testData")
    void sortByReflection(int[] nums, int[] expected) {
        var solution = new SortIntegersByBinaryReflection();
        assertArrayEquals(expected, solution.sortByReflection(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {4,5,4}, new int[] {4,4,5}),
                Arguments.of(new int[] {3,6,5,8}, new int[] {8,3,6,5})
        );
    }

}
