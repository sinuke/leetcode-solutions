package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MostFrequentEvenElementTest {

    @ParameterizedTest
    @MethodSource("testData")
    void mostFrequentEven(int[] nums, int expected) {
        var solution = new MostFrequentEvenElement();
        assertEquals(expected, solution.mostFrequentEven(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {0,1,2,2,4,4,1}, 2),
                Arguments.of(new int[] {4,4,4,9,2,4}, 4),
                Arguments.of(new int[] {29,47,21,41,13,37,25,7}, -1)
        );
    }

}
