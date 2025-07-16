package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongerContiguousSegmentsOfOnesThanZerosTest {

    @ParameterizedTest
    @MethodSource("testData")
    void checkZeroOnes(String s, boolean expected) {
        var solution = new LongerContiguousSegmentsOfOnesThanZeros();
        assertEquals(expected, solution.checkZeroOnes(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("1101", true),
                Arguments.of("111000", false),
                Arguments.of("110100010", false)
        );
    }

}
