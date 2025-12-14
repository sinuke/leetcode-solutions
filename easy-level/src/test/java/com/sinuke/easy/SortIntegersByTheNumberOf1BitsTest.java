package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortIntegersByTheNumberOf1BitsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void sortByBits(int[] arr, int[] expected) {
        var solution = new SortIntegersByTheNumberOf1Bits();
        assertArrayEquals(expected, solution.sortByBits(arr));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {0,1,2,3,4,5,6,7,8}, new int[] {0,1,2,4,8,3,5,6,7}),
                Arguments.of(new int[] {1024,512,256,128,64,32,16,8,4,2,1}, new int[] {1,2,4,8,16,32,64,128,256,512,1024})
        );
    }

}
