package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumStrongPairXORITest {

    @ParameterizedTest
    @MethodSource("testData")
    void maximumStrongPairXor(int[] nums, int expected) {
        var solution = new MaximumStrongPairXORI();
        assertEquals(expected, solution.maximumStrongPairXor(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,2,3,4,5}, 7),
                Arguments.of(new int[] {10,100}, 0),
                Arguments.of(new int[] {5,6,25,30}, 7)
        );
    }

}
