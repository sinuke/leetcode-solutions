package com.sinuke;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class PlusOneTest {

    @ParameterizedTest
    @MethodSource("testData")
    void plusOne(int[] input, int[] expected) {
        var plusOne = new PlusOne();
        assertArrayEquals(expected, plusOne.plusOne(input));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1, 2, 3}, new int[] {1, 2, 4}),
                Arguments.of(new int[] {4, 3, 2, 1}, new int[] {4, 3, 2, 2}),
                Arguments.of(new int[] {9}, new int[] {1, 0})
        );
    }

}
