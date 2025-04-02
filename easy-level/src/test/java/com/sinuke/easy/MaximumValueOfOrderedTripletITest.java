package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumValueOfOrderedTripletITest {

    @ParameterizedTest
    @MethodSource("testData")
    void maximumTripletValue(int[] nums, long expected) {
        var solution = new MaximumValueOfOrderedTripletI();
        assertEquals(expected, solution.maximumTripletValue(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {12,6,1,2,7}, 77),
                Arguments.of(new int[] {1,10,3,4,19}, 133),
                Arguments.of(new int[] {1,2,3}, 0),
                Arguments.of(new int[] {1000000,1,1000000}, 999999000000L)
        );
    }

}
