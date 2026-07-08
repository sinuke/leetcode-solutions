package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumOfIntegersWithMaximumDigitRangeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maxDigitRange(int[] nums, int expected) {
        assertEquals(expected, new SumOfIntegersWithMaximumDigitRange().maxDigitRange(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{5724, 111, 350}, 6074),
                Arguments.of(new int[]{90, 900}, 990)
        );
    }

}
