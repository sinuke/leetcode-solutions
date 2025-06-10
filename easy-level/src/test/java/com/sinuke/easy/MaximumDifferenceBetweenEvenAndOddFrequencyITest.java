package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumDifferenceBetweenEvenAndOddFrequencyITest {

    @ParameterizedTest
    @MethodSource("testData")
    void maxDifference(String s, int expected) {
        var solution = new MaximumDifferenceBetweenEvenAndOddFrequencyI();
        assertEquals(expected, solution.maxDifference(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("aaaaabbc", 3),
                Arguments.of("abcabcab", 1),
                Arguments.of("tzt", -1),
                Arguments.of("yzyyys", -3)
        );
    }

}
