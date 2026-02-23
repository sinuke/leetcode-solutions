package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MeanOfArrayAfterRemovingSomeElementsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void trimMean(int[] arr, double expected) {
        var solution = new MeanOfArrayAfterRemovingSomeElements();
        assertEquals(expected, solution.trimMean2(arr), 0.00001d);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3}, 2.00000d),
                Arguments.of(new int[] {6,2,7,5,1,2,0,3,10,2,5,0,5,5,0,8,7,6,8,0}, 4.00000d),
                Arguments.of(new int[] {6,0,7,0,7,5,7,8,3,4,0,7,8,1,6,8,1,1,2,4,8,1,9,5,4,3,8,5,10,8,6,6,1,0,6,10,8,2,3,4}, 4.77778d)
        );
    }

}
