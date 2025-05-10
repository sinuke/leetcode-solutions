package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KeepMultiplyingFoundValuesByTwoTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findFinalValue(int[] nums, int k, int expected) {
        var solution = new KeepMultiplyingFoundValuesByTwo();
        assertEquals(expected, solution.findFinalValue(nums, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {5,3,6,1,12}, 3, 24),
                Arguments.of(new int[] {2,7,9}, 4, 4)
        );
    }

}
