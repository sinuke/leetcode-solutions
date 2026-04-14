package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FirstMatchingCharacterFromBothEndsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void firstMatchingIndex(String s, int expected) {
        assertEquals(expected, new FirstMatchingCharacterFromBothEnds().firstMatchingIndex(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("abcacbd", 1),
                Arguments.of("abc", 1),
                Arguments.of("abcdab", -1)
        );
    }

}
