package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SecondLargestDigitInStringTest {

    @ParameterizedTest
    @MethodSource("testData")
    void secondHighest(String s, int expected) {
        var solution = new SecondLargestDigitInString();
        assertEquals(expected, solution.secondHighest(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("dfa12321afd", 2),
                Arguments.of("abc1111", -1)
        );
    }

}
