package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BitwiseOROfEvenNumbersInArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void evenNumberBitwiseORs(int[] nums, int expected) {
        var solution = new BitwiseOROfEvenNumbersInArray();
        assertEquals(expected, solution.evenNumberBitwiseORs(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,2,3,4,5,6}, 6),
                Arguments.of(new int[] {7,9,11}, 0),
                Arguments.of(new int[] {1,8,16}, 24)
        );
    }

}
