package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfBeautifulPairsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countBeautifulPairs(int[] nums, int expected) {
        var solution = new NumberOfBeautifulPairs();
        assertEquals(expected, solution.countBeautifulPairs(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {2,5,1,4}, 5),
                Arguments.of(new int[] {11,21,12}, 2)
        );
    }

}
