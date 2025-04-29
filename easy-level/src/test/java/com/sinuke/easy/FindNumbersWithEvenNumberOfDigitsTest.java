package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindNumbersWithEvenNumberOfDigitsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findNumbers(int[] nums, int expected) {
        var solution = new FindNumbersWithEvenNumberOfDigits();
        assertEquals(expected, solution.findNumbers(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {12,345,2,6,7896}, 2),
                Arguments.of(new int[] {555,901,482,1771}, 1)
        );
    }

}
