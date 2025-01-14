package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FindThePrefixCommonArrayOfTwoArraysTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findThePrefixCommonArray(int[] A, int[] B, int[] expected) {
        var finder = new FindThePrefixCommonArrayOfTwoArrays();
        assertArrayEquals(expected, finder.findThePrefixCommonArray(A, B));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,3,2,4}, new int[] {3,1,2,4}, new int[] {0,2,3,4}),
                Arguments.of(new int[] {2,3,1}, new int[] {3,1,2}, new int[] {0,1,3})
        );
    }

}
