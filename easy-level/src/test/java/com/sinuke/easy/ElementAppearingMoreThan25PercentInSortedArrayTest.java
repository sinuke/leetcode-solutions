package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ElementAppearingMoreThan25PercentInSortedArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findSpecialInteger(int[] arr, int expected) {
        var solution = new ElementAppearingMoreThan25PercentInSortedArray();
        assertEquals(expected, solution.findSpecialInteger(arr));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,2,2,6,6,6,6,7,10}, 6),
                Arguments.of(new int[] {1,1}, 1)
        );
    }

}
