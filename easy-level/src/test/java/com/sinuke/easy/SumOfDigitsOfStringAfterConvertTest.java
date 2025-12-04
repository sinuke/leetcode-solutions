package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumOfDigitsOfStringAfterConvertTest {

    @ParameterizedTest
    @MethodSource("testData")
    void getLucky(String s, int k, int expected) {
        var solution = new SumOfDigitsOfStringAfterConvert();
        assertEquals(expected, solution.getLucky(s, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("iiii", 1, 36),
                Arguments.of("leetcode", 2, 6),
                Arguments.of("zbax", 2, 8),
                Arguments.of("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz", 1, 800),
                Arguments.of("ssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss", 1, 1000),
                Arguments.of("iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii", 1, 900)
        );
    }

}
