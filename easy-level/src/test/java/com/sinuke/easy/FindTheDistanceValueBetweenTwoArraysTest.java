package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindTheDistanceValueBetweenTwoArraysTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findTheDistanceValue(int[] arr1, int[] arr2, int d, int expected) {
        var solution = new FindTheDistanceValueBetweenTwoArrays();
        assertEquals(expected, solution.findTheDistanceValue(arr1, arr2, d));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {4,5,8}, new int[] {10,9,1,8}, 2, 2),
                Arguments.of(new int[] {1,4,2,3}, new int[] {-4,-3,6,10,20,30}, 3, 2),
                Arguments.of(new int[] {2,1,100,3}, new int[] {-5,-2,10,-3,7}, 6, 1)
        );
    }

}
