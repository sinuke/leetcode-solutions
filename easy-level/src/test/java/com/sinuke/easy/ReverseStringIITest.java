package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseStringIITest {

    @ParameterizedTest
    @MethodSource("testData")
    void reverseStr(String s, int k, String expected) {
        var solution = new ReverseStringII();
        assertEquals(expected, solution.reverseStr(s, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("abcdefg", 2, "bacdfeg"),
                Arguments.of("abcd", 2, "bacd")
        );
    }

}
