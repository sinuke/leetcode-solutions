package com.sinuke;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FinalArrayStateAfterKMultiplicationOperationsITest {

    @ParameterizedTest
    @MethodSource("testData")
    void getFinalState(int[] nums, int k, int multiplier, int[] expected) {
        var finalArrayStateAfterKMultiplicationOperationsI = new FinalArrayStateAfterKMultiplicationOperationsI();
        assertArrayEquals(expected, finalArrayStateAfterKMultiplicationOperationsI.getFinalState(nums, k, multiplier));
    }
    
    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {2, 1, 3, 5, 6}, 5, 2, new int[] {8, 4, 6, 5, 6}),
                Arguments.of(new int[] {1, 2}, 3, 4, new int[] {16, 8}),
                Arguments.of(new int[] {1, 3, 5}, 5, 3, new int[] {27, 9, 15})
        );
    }
    
}
