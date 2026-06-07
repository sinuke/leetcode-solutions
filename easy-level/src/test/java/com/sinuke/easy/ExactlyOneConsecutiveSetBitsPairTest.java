package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExactlyOneConsecutiveSetBitsPairTest {

    @ParameterizedTest
    @MethodSource("testData")
    void consecutiveSetBits(int n, boolean expected) {
        assertEquals(expected, new ExactlyOneConsecutiveSetBitsPair().consecutiveSetBits(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(6, true),
                Arguments.of(5, false)
        );
    }

}
