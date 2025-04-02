package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumOfUniqueElementsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void sumOfUnique(int[] nums, int expected) {
        var solution = new SumOfUniqueElements();
        assertEquals(expected, solution.sumOfUnique(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,2,3,2}, 4),
                Arguments.of(new int[] {1,1,1,1,1}, 0),
                Arguments.of(new int[] {1,2,3,4,5}, 15)
        );
    }

}
