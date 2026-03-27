package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConstructUniformParityArrayITest {

    @ParameterizedTest
    @MethodSource("testData")
    void uniformArray(int[] nums1, boolean expected) {
        var solution = new ConstructUniformParityArrayI();
        assertEquals(expected, solution.uniformArray(nums1));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {2,3}, true),
                Arguments.of(new int[] {4,6}, true)
        );
    }

}
