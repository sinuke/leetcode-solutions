package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SortVowelsInStringTest {

    @ParameterizedTest
    @MethodSource("testData")
    void sortVowels(String s, String expected) {
        var solution = new SortVowelsInString();
        assertEquals(expected, solution.sortVowels(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("lEetcOde", "lEOtcede"),
                Arguments.of("lYmpH", "lYmpH")
        );
    }

}
