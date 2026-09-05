package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountIntegersAppearingInSingleBlockTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countSpecialIntegers(int[] input, int expected) {
        var solution = new CountIntegersAppearingInSingleBlock();
        assertEquals(expected, solution.countSpecialIntegers(input));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1, 2, 2, 1}, 1),
                Arguments.of(new int[] {3, 3, 1, 2, 2, 1}, 2)
        );
    }

}