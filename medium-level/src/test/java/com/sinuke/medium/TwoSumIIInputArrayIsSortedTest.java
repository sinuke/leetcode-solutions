package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TwoSumIIInputArrayIsSortedTest {

    @ParameterizedTest
    @MethodSource("testData")
    void twoSum(int[] numbers, int target, int[] expected) {
        assertArrayEquals(expected, new TwoSumIIInputArrayIsSorted().twoSum(numbers, target));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{2, 7, 11, 15}, 9, new int[]{1, 2}),
                Arguments.of(new int[]{2, 3, 4}, 6, new int[]{1, 3}),
                Arguments.of(new int[]{-1, 0}, -1, new int[]{1, 2})
        );
    }

}
