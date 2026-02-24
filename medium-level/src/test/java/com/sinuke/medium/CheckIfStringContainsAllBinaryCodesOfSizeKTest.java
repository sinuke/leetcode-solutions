package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckIfStringContainsAllBinaryCodesOfSizeKTest {

    @ParameterizedTest
    @MethodSource("testData")
    void hasAllCodes(String s, int k, boolean expected) {
        var solution = new CheckIfStringContainsAllBinaryCodesOfSizeK();
        assertEquals(expected, solution.hasAllCodes(s, k));
        assertEquals(expected, solution.hasAllCodes2(s, k));
        assertEquals(expected, solution.hasAllCodes3(s, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("00110110", 2, true),
                Arguments.of("0110", 1, true),
                Arguments.of("0110", 2, false)
        );
    }

}
