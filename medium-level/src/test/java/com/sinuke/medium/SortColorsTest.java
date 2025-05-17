package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortColorsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void sortColors(int[] nums, int[] expected) {
        var solution = new SortColors();
        solution.sortColors(nums);
        assertArrayEquals(expected, nums);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {2,0,2,1,1,0}, new int[] {0,0,1,1,2,2}),
                Arguments.of(new int[] {2,0,1}, new int[] {0,1,2})
        );
    }

}
