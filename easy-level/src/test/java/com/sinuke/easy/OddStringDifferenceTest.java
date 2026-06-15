package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OddStringDifferenceTest {

    @ParameterizedTest
    @MethodSource("testData")
    void oddString(String[] words, String expected) {
        assertEquals(expected, new OddStringDifference().oddString(words));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new String[]{"adc", "wzy", "abc"}, "abc"),
                Arguments.of(new String[]{"aaa", "bob", "ccc", "ddd"}, "bob")
        );
    }

}
