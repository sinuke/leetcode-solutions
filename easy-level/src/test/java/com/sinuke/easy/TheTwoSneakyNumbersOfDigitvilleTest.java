package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TheTwoSneakyNumbersOfDigitvilleTest {

    @ParameterizedTest
    @MethodSource("testData")
    void getSneakyNumbers(int[] nums, int[] expected) {
        var twoSneakyNumbers = new TheTwoSneakyNumbersOfDigitville();
        var actual1 = twoSneakyNumbers.getSneakyNumbers(nums);
        var actual2 = twoSneakyNumbers.getSneakyNumbers2(nums);
        Arrays.sort(actual1);
        Arrays.sort(actual2);
        assertArrayEquals(expected, actual1);
        assertArrayEquals(expected, actual2);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {0,1,1,0}, new int[] {0, 1}),
                Arguments.of(new int[] {0,3,2,1,3,2}, new int[] {2,3}),
                Arguments.of(new int[] {7,1,5,4,3,4,6,0,9,5,8,2}, new int[] {4, 5})
        );
    }

}