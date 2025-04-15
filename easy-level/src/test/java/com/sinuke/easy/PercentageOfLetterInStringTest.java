package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PercentageOfLetterInStringTest {

    @ParameterizedTest
    @MethodSource("testData")
    void percentageLetter(String s, char letter, int expected) {
        var solution = new PercentageOfLetterInString();
        assertEquals(expected, solution.percentageLetter(s, letter));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("foobar", 'o', 33),
                Arguments.of("jjjj", 'k', 0)
        );
    }

}
