package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TransformArrayByParityTest {

    @ParameterizedTest
    @MethodSource("testData")
    void transformArray(int[] nums, int[] expected) {
        var solution = new TransformArrayByParity();
        assertArrayEquals(expected, solution.transformArray(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {4,3,2,1}, new int[] {0,0,1,1}),
                Arguments.of(new int[] {1,5,1,4,2}, new int[] {0,0,1,1,1})
        );
    }

}
