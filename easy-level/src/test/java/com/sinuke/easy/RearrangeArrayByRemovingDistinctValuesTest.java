package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class RearrangeArrayByRemovingDistinctValuesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void rearrangeArray(int[] nums, int[] expected) {
        var solution = new RearrangeArrayByRemovingDistinctValues();
        assertArrayEquals(expected, solution.rearrangeArray(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {3, 1, 3, 2, 1, 3}, new int[] {1, 2, 3, 1, 3, 3}),
                Arguments.of(new int[] {7, 7, 4, 4, 4}, new int[] {4, 7, 4, 7, 4})
        );
    }

}
