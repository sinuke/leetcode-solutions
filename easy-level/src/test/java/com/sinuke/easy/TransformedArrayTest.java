package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TransformedArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void constructTransformedArray(int[] nums, int[] expected) {
        var solution = new TransformedArray();
        assertArrayEquals(expected, solution.constructTransformedArray(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {3,-2,1,1}, new int[] {1,1,1,3}),
                Arguments.of(new int[] {-1,4,-1}, new int[] {-1,-1,4})
        );
    }

}
