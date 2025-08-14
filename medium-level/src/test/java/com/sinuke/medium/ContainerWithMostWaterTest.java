package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContainerWithMostWaterTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maxArea(int[] height, int expected) {
        var solution = new ContainerWithMostWater();
        assertEquals(expected, solution.maxArea(height));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,8,6,2,5,4,8,3,7}, 49),
                Arguments.of(new int[] {1, 1}, 1)
        );
    }

}
