package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ConcatenateArrayWithReverseTest {

    @ParameterizedTest
    @MethodSource("testData")
    void concatWithReverse(int[] nums, int[] expected) {
        assertArrayEquals(expected, new ConcatenateArrayWithReverse().concatWithReverse(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, new int[]{1, 2, 3, 3, 2, 1}),
                Arguments.of(new int[]{1}, new int[]{1, 1})
        );
    }

}
