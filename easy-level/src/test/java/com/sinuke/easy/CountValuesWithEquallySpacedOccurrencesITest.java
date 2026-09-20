package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountValuesWithEquallySpacedOccurrencesITest {

    @ParameterizedTest
    @MethodSource("testData")
    void findSpecialInteger(int[] nums, int expected) {
        var solution = new CountValuesWithEquallySpacedOccurrencesI();
        assertEquals(expected, solution.countSpecialIntegers(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1, 8, 1, 5, 1, 5, 8, 5}, 2),
                Arguments.of(new int[] {8, 8, 8, 8}, 0),
                Arguments.of(new int[] {8, 6, 6, 8, 8}, 0)
        );
    }

}
