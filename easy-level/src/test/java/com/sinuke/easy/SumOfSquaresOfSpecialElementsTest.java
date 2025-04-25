package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumOfSquaresOfSpecialElementsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void sumOfSquares(int[] nums, int expected) {
        var solution = new SumOfSquaresOfSpecialElements();
        assertEquals(expected, solution.sumOfSquares(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,2,3,4}, 21),
                Arguments.of(new int[] {2,7,1,19,18,3}, 63)
        );
    }

}
