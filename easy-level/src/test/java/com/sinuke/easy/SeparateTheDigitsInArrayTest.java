package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SeparateTheDigitsInArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void separateDigits(int[] nums, int[] expected) {
        var solution = new SeparateTheDigitsInArray();
        assertArrayEquals(expected, solution.separateDigits(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {13,25,83,77}, new int[] {1,3,2,5,8,3,7,7}),
                Arguments.of(new int[] {7,1,3,9}, new int[] {7,1,3,9})
        );
    }

}
