package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountResiduePrefixesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void residuePrefixes(String s, int expected) {
        var solution = new CountResiduePrefixes();
        assertEquals(expected, solution.residuePrefixes(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("abc", 2),
                Arguments.of("dd", 1),
                Arguments.of("bob", 2)
        );
    }

}
