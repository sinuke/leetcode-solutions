package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimizeStringLengthTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minimizedStringLength(String s, int expected) {
        var solution = new MinimizeStringLength();
        assertEquals(expected, solution.minimizedStringLength(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("aaabc", 3),
                Arguments.of("cbbd", 3),
                Arguments.of("baadccab", 4)
        );
    }

}
