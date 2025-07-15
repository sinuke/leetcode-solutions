package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidWordTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isValid(String word, boolean expected) {
        var solution = new ValidWord();
        assertEquals(expected, solution.isValid(word));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("234Adas", true),
                Arguments.of("b3", false),
                Arguments.of("a3$e", false)
        );
    }

}
