package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LargestOddNumberInStringTest {

    @ParameterizedTest
    @MethodSource("testData")
    void largestOddNumber(String num, String expected) {
        var solution = new LargestOddNumberInString();
        assertEquals(expected, solution.largestOddNumber(num));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("52", "5"),
                Arguments.of("4206", ""),
                Arguments.of("35427", "35427")
        );
    }

}
