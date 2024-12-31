package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ToLowerCaseTest {

    @ParameterizedTest
    @MethodSource("testData")
    void toLowerCase(String s, String expected) {
        var toLowerCase = new ToLowerCase();
        assertEquals(expected, toLowerCase.toLowerCase(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("Hello", "hello"),
                Arguments.of("here", "here"),
                Arguments.of("LOVELY", "lovely"),
                Arguments.of("123", "123")
        );
    }

}
