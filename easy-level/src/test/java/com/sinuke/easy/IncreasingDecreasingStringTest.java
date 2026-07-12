package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IncreasingDecreasingStringTest {

    @ParameterizedTest
    @MethodSource("testData")
    void sortString(String s, String expected) {
        assertEquals(expected, new IncreasingDecreasingString().sortString(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("aaaabbbbcccc", "abccbaabccba"),
                Arguments.of("rat", "art")
        );
    }

}
