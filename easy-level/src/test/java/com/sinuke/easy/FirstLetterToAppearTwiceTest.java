package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FirstLetterToAppearTwiceTest {

    @ParameterizedTest
    @MethodSource("testData")
    void repeatedCharacter(String s, char expected) {
        var solution = new FirstLetterToAppearTwice();
        assertEquals(expected, solution.repeatedCharacter(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("abccbaacz", 'c'),
                Arguments.of("abcdd", 'd')
        );
    }

}
