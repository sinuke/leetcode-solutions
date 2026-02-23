package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KthMissingPositiveNumberTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findKthPositive(int[] arr, int k, int expected) {
        var solution = new KthMissingPositiveNumber();
        assertEquals(expected, solution.findKthPositive(arr, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {2,3,4,7,11}, 5, 9),
                Arguments.of(new int[] {1,2,3,4}, 2, 6)
        );
    }

}
