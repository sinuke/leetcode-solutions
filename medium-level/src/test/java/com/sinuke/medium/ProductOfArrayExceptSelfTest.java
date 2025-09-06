package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductOfArrayExceptSelfTest {

    @ParameterizedTest
    @MethodSource("testData")
    void productExceptSelf(int[] nums, int[] expected) {
        var solution = new ProductOfArrayExceptSelf();
        assertArrayEquals(expected, solution.productExceptSelf(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,2,3,4}, new int[] {24,12,8,6}),
                Arguments.of(new int[] {-1,1,0,-3,3}, new int[] {0,0,9,0,0})
        );
    }

}
