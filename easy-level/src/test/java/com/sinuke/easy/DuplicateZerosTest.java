package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DuplicateZerosTest {

    @ParameterizedTest
    @MethodSource("testData")
    void duplicateZeros(int[] arr, int[] expected) {
        var solution = new DuplicateZeros();
        solution.duplicateZeros(arr);
        assertArrayEquals(expected, arr);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,0,2,3,0,4,5,0}, new int[] {1,0,0,2,3,0,0,4}),
                Arguments.of(new int[] {1,2,3}, new int[] {1,2,3})
        );
    }

}
