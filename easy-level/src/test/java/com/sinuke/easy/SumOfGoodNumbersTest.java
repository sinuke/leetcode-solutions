package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumOfGoodNumbersTest {

    @ParameterizedTest
    @MethodSource("testData")
    void sumOfGoodNumbers(int[] nums, int k, int expected) {
        var solution = new SumOfGoodNumbers();
        assertEquals(expected, solution.sumOfGoodNumbers(nums, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,3,2,1,5,4}, 2, 12),
                Arguments.of(new int[] {2,1}, 1, 2)
        );
    }

}
