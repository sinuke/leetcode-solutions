package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FaultyKeyboardTest {

    @ParameterizedTest
    @MethodSource("testData")
    void finalString(String s, String expected) {
        var solution = new FaultyKeyboard();
        assertEquals(expected, solution.finalString(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("string", "rtsng"),
                Arguments.of("poiinter", "ponter")
        );
    }

}
