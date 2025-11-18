package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximizeExpressionOfThreeElementsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maximizeExpressionOfThree(int[] nums, int expected) {
        var solution = new MaximizeExpressionOfThreeElements();
        assertEquals(expected, solution.maximizeExpressionOfThree(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,4,2,5}, 8),
                Arguments.of(new int[] {-2,0,5,-2,4}, 11),
                Arguments.of(new int[] {-4,-8,-10}, -2)
        );
    }

}
