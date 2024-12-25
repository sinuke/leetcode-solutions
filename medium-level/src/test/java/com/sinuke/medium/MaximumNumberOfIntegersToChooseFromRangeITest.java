package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MaximumNumberOfIntegersToChooseFromRangeITest {

    @ParameterizedTest
    @MethodSource("testData")
    void maxCount(int[] banned, int n, int maxSum, int expected) {
        var maximumNumbers = new MaximumNumberOfIntegersToChooseFromRangeI();
        assertEquals(expected, maximumNumbers.maxCount(banned, n, maxSum));
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1, 5, 6}, 5, 6, 2),
                Arguments.of(new int[] {1, 2, 3, 4, 5, 6, 7}, 8, 1, 0),
                Arguments.of(new int[] {11}, 7, 50, 7)
        );
    }

}
