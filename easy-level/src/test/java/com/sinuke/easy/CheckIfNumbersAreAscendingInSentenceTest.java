package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckIfNumbersAreAscendingInSentenceTest {

    @ParameterizedTest
    @MethodSource("testData")
    void areNumbersAscending(String s, boolean expected) {
        var solution = new CheckIfNumbersAreAscendingInSentence();
        assertEquals(expected, solution.areNumbersAscending(s));
        assertEquals(expected, solution.areNumbersAscending2(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("1 box has 3 blue 4 red 6 green and 12 yellow marbles", true),
                Arguments.of("hello world 5 x 5", false),
                Arguments.of("sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s", false)
        );
    }

}
