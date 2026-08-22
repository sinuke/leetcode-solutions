package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidMountainArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void validMountainArray(int[] arr, boolean expected) {
        var solution = new ValidMountainArray();
        assertEquals(expected, solution.validMountainArray(arr));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{2, 1}, false),
                Arguments.of(new int[]{3, 5, 5}, false),
                Arguments.of(new int[]{0, 3, 2, 1}, true)
        );
    }

}
