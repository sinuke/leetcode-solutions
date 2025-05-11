package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThreeConsecutiveOddsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void threeConsecutiveOdds(int[] arr, boolean expected) {
        var solution = new ThreeConsecutiveOdds();
        assertEquals(expected, solution.threeConsecutiveOdds(arr));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {2,6,4,1}, false),
                Arguments.of(new int[] {1,2,34,3,4,5,7,23,12}, true)
        );
    }

}
