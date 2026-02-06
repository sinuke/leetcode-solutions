package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseLettersThenSpecialCharactersInStringTest {

    @ParameterizedTest
    @MethodSource("testData")
    void reverseByType(String s, String expected) {
        var solution = new ReverseLettersThenSpecialCharactersInString();
        assertEquals(expected, solution.reverseByType(s));
        assertEquals(expected, solution.reverseByType2(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(")ebc#da@f(", "(fad@cb#e)"),
                Arguments.of("z", "z"),
                Arguments.of("!@#$%^&*()", ")(*&^%$#@!")
        );
    }

}
