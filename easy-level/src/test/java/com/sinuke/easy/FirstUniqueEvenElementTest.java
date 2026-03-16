package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FirstUniqueEvenElementTest {

    @ParameterizedTest
    @MethodSource("testData")
    void firstUniqueEven(int[] nums, int expected) {
        var solution = new FirstUniqueEvenElement();
        assertEquals(expected, solution.firstUniqueEven(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {3,4,2,5,4,6}, 2),
                Arguments.of(new int[] {4,4}, -1)
        );
    }

}
